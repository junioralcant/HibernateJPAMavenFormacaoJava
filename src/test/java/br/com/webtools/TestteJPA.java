package br.com.webtools;

import javax.persistence.Persistence;

public class TestteJPA {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("meuprimeiroprojetojsf02");
	}
}
