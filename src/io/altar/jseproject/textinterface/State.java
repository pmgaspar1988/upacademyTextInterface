package io.altar.jseproject.textinterface;

import io.altar.jseproject.repository.ProductRepository;
import io.altar.jseproject.repository.ShelfRepository;
import utils.ScannerUtils;

public abstract class State {
	static ProductRepository baseDadosProd = ProductRepository.getInstance();
	static ShelfRepository baseDadosShel = ShelfRepository.getInstance();
	
	public static ScannerUtils sc = new ScannerUtils();
	
	public abstract int on();
}
