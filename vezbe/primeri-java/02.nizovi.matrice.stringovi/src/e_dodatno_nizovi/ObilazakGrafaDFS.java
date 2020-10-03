package e_dodatno_nizovi;

public class ObilazakGrafaDFS {

	/**
	 * Program ilustruje DFS algoritam za obilazak grafa (obilazak u dubinu).
	 * Graf cuvamo u matrici, a polje (i, j) je definisano kao:
	 * a[i][j] = 1 => cvor i ima granu ka cvoru j
	 * a[i][j] = 0 => cvor i nema granu ka cvoru j
	 * 
     *      +----------+
     *      |          |
     *      |        +-+-+         +---+
     *      |    +-> | 0 +-------> | 1 +---+
     *      |    |   +---+         +---+   |
     *      |    |                         |
     *      |    |   +---+         +---+   |
     *      |    +---+ 2 +------>  | 4 | <-+
     *      |        +-+-+         +-+-+
     *      |          |             |
     *      |          |    +---+    |
     *      |          +--> | 3 | <--+
     *      |               +-+-+
     *      |                 ^
     *      |                 |
     *      +-----------------+
     */	

	public static void main(String[] args) {
		// Primetimo da smo mogli da graf cuvamo u matrici tipa 'boolean' umesto 'int'
		// jer u izlozenom primeru, jedino nam je potrebna informacija o tome da li postoji
		// usmerena grana iz cvora 'i' ka cvoru 'j'.
		int[][] graph = {
			{0, 1, 0, 1, 0},
			{0, 0, 0, 0, 1},
			{0, 0, 0, 1, 1},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0},
		};
		
		// Niz nam cuva podatak o tome koji smo cvor posetili.
		// visited[i] = true => posetili smo cvor i
		// visited[i] = false => nismo posetili cvor i
		boolean[] visited = {false, false, false, false, false};
		
		int startNode = 0;
		performDfs(graph, startNode, visited);
	}

	static void performDfs(int[][] graph, int currentNode, boolean[] visited) {
		// Oznacavamo trenutni cvor kao posecen
		visited[currentNode] = true;
		System.out.println(currentNode);

		// Obilazimo sve neposecene susede tekuceg cvora
		for (int i = 0; i < graph.length; i++) {
			// ako postoji put od cvora 'i' do cvora 'j' i cvor 'j' nije posecen
			if (!visited[i] && graph[currentNode][i] == 1)
				performDfs(graph, i, visited);
		}
	}

}
