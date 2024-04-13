package ejercicio_files_y_basesdedatos.util;

import java.nio.file.DirectoryStream.Filter;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import javax.accessibility.AccessibleStateSet;

public class HerramientasMigue {

	public <T> Optional<T> entontrarElementoMasViejo(Collection<T> collectionEntrada, Comparator<T> comparador) {
		
		return collectionEntrada.stream().max(comparador); 
	}
	
	public <T> Optional<T> entontrarElementoMasJoven(Collection<T> collectionEntrada, Comparator<T> comparador) {
		
		return collectionEntrada.stream().min(comparador); 
	}
	
	public <T> double encontrarPromedio(Collection<T> collectionEntrada, ToDoubleFunction<T> comparador){
	
//		Double promedio = collectionEntrada.stream().mapToDouble(comparador::)
		
		return collectionEntrada.stream()
								.mapToDouble(comparador::applyAsDouble)
								.average()
								.orElse(0);
	}
	
	public <T> List<T> ordenarEmpleadosAlfabetico(Collection<T> collectionEntrada, Function<T, String> nombrePorOrden){
		return collectionEntrada.stream().sorted(Comparator.comparing(nombrePorOrden::apply)).collect(Collectors.toList()); 
	}
	
	public <T> void lecturaElementosColeccion (Collection <T> collection) {
		
		for (T i: collection) {
			System.out.println(i.toString());
		}
		
	}
	
	public <T> void lecturaElementosList (List <T> lista) {
		
		for (T i: lista) {
			System.out.println(i.toString());
		}
		
	}
	
	public <K,V> void lecturaElementosMapa (Map <K,V> map) {
		map.forEach((K,V) -> System.out.println("Clave : " + K + " Valor : " + V) );
	}
	
	// Método que reciba una lista y filtro genérico y que devuelva la misma lista aplicando el filtro. 
	
	public <T> void listaConFiltroGen (Collection<T> lista , Function<T, String> filtro){
		
		 lista.stream().sorted(Comparator.comparing(filtro::apply)).collect(Collectors.toList()).forEach(System.out::println); 
		 
		
	}
}
