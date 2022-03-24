package model.nullobjects;

import model.Usuario;

public class NullUser extends Usuario {

	public static Usuario build() throws Exception {
		return new NullUser();
	}
	

	public NullUser()throws Exception{
		super("",0.0,0.0, null,"", false);
	}
	
	public boolean isNull() {
		return true;
}
	
}
