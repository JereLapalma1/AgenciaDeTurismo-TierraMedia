package model;

public class Itinerario {
	private Long id;
	private Usuario usuario;
	private Ofertable ofertable;

	

	public Itinerario(Usuario usuario, Ofertable ofertable) {		this.usuario = usuario;
		this.ofertable = ofertable;
	}
	
	public Itinerario(Long id, Usuario usuario, Ofertable ofertable) {
		this.id = id;
		this.usuario = usuario;
		this.ofertable = ofertable;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", usuario: " + usuario + ", ofertable: " + ofertable;
	}

	public Long getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Ofertable getOfertable() {
		return ofertable;
	}

}
