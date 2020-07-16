import java.util.Comparator;

public class OrdenarPorGenero implements Comparator<Elemento>{

	public int compare(Elemento e1, Elemento e2) {
		return e1.getGenero().compareTo(e2.getGenero());
	}

}
