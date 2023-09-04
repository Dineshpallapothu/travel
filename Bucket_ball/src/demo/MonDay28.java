package demo;

public class MonDay28 {
	public static void main(String[] args) {
	String arr[]= {"The quick brown fox", "jumps over the lazy dog", "The lazy dog barks"};
		
	Set<String> distinctWords=Arrays.stream(arr).flatMap(sen -> Arrays.stream(sen.toLowerCase().split(" ")))
			.map(word -> word.replaceAll("[^a-z]", "")).filter(word -> !word.isEmpty()).collect(Collectors.toSet());
	
	System.out.println(distinctWords);
	}
}


