package de.thro.inf.prg3.a06;

import com.google.gson.Gson;
import de.thro.inf.prg3.a06.model.Joke;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) {
		// TODO fetch a random joke and print it to STDOUT
		Gson gson = new Gson();

		// JSON String --> Object
		Joke j = gson.fromJson("{\"id\": 0, \"joke\": \"Haha.\", \"rubrics\": [\"flachwitz\", \"blondienenwitz\", \"kommentar\"]}", Joke.class);
		// categories remains `null`

		// Object --> JSON String
		String json = gson.toJson(j);

		System.out.println(json);
	}

}
