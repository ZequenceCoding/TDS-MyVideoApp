package umu.tds.myvideoapp.dominio;

public interface ITest<T> {

	boolean test (T o);
	String getNombre();
	String getNombreClase();
}
