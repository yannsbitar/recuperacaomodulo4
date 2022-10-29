package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class viagem {
	private int id;
	public int getId() {
		return id;
	}
	private int idviagem;
	private LocalDate ida;
	private LocalDate volta;
	private int destino;
	private Cliente cliente;
	 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	 
	public viagem() {
	
	}
	
	
	 
	public viagem(int id, int idviagem, String  ida, String volta, int destino, Cliente cliente) {
		this.id = id;
		this.idviagem = idviagem;
		this.ida = LocalDate.parse(ida, formatter);
		this.volta = LocalDate.parse(volta, formatter);
		this.destino = destino;
		this.cliente = cliente;
	}



	public int getIdviagem() {
		return idviagem;
	}



	public void setIdviagem(int idviagem) {
		this.idviagem = idviagem;
	}



	public String getIda() {
		return formatter.format(ida);
	}



	public void setIda(String ida) {
		this.ida = LocalDate.parse(ida, formatter);
	}



	public String getVolta() {
		return formatter.format(volta);
	}



	public void setVolta(String volta) {
		this.volta = LocalDate.parse(volta, formatter);
	}



	public int getDestino() {
		return destino;
	}



	public void setDestino(int destino) {
		this.destino = destino;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
}
