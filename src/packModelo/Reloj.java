package packModelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj extends Observable{
	private boolean pausado;
	private int tiempoSeg, tiempoMin, tiempoHor;
	private static Reloj mReloj;
	private Timer timer;
	
	private Reloj(){
		pausado = true;
		tiempoSeg = 0;
		tiempoMin = 0;
		tiempoHor = 0;
		TimerTask  timerTask = new TimerTask() {
			@Override
			public void run() {
				updateSeconds();				
			}
		};
		timer = new Timer();
		//cada segundo se ejecuta
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	public static Reloj getGestor(){
		if(mReloj == null){
			mReloj = new Reloj();
		}
		return mReloj;
	}
	
	private void updateSeconds(){
		if(!this.pausado){	
			tiempoSeg++;
			if(tiempoSeg==60){
				tiempoMin++;
				tiempoSeg=0;
				if(tiempoMin==60){
					tiempoHor++;
					tiempoMin=0;
				}
			}
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	//POST: devuelve string con formato hh:mm:ss 
	public String tiempoAString(){
		String ts =Integer.toString(tiempoSeg);
		String tm =Integer.toString(tiempoMin);
		String th =Integer.toString(tiempoHor);
		//modificaciones visuales, 0:0 -> 00:00
		if (tiempoSeg<10) ts = "0"+ts;
		if (tiempoMin<10) tm = "0"+tm;
		if (tiempoHor<10) th = "0"+th;
		
		return th +":"+ tm +":"+ ts;
	}
	
	//POST: devuelve segundos totales
	public int tiempoASegundos(){
		return tiempoSeg + tiempoMin*60 + tiempoHor*3600;
	}
	
	//POST: inicia el reloj en pSeg
	public void setTiempo(int pSeg){
		tiempoHor=pSeg/3600;
		tiempoMin=(pSeg%3600)/60;
		tiempoSeg=(pSeg%3600)%60;
		this.setChanged();
		this.notifyObservers();	}
	
	//POST: pausamos el reloj
	public void pausar() {
		this.pausado = true;
	}

	//POST: reanudamos el reloj
	public void reanudar() {
		this.pausado = false;
	}
}
