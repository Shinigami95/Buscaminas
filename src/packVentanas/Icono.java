package packVentanas;

import javax.swing.ImageIcon;

public class Icono {
	
	private ImageIcon mina;
	private static Icono icon;
	
	private Icono(){
		mina=new ImageIcon("mina.jpg");
	}
	
	public static Icono getIcono(){
		if(icon==null){
			icon=new Icono();
		}
		return icon;
	}
	
	public ImageIcon getMina(){
		return mina;
	}
	
}
