import java.util.Comparator;

public class OrdenarPorDuracion implements Comparator<Elemento>{

	public int compare(Elemento e1, Elemento e2) {
		return e1.getDuracion()-e2.getDuracion();
	}

}
