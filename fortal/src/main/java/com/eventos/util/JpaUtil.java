package com.eventos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	// EntityManager é responsável por gerenciar entidades no contexto de persistência
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("fortalPU");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
