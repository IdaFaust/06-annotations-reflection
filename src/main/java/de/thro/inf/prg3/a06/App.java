package de.thro.inf.prg3.a06;

import com.google.gson.Gson;
import de.thro.inf.prg3.a06.model.Joke;
import de.thro.inf.prg3.a06.model.JokeResponse;
import de.thro.inf.prg3.a06.model.JokesResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		// TODO fetch a random joke and print it to STDOUT
		Gson gson = new Gson();

		// JSON String --> Object (deserialize)
		Joke j = gson.fromJson("{\"id\": 0, \"joke\": \"Haha.\", \"rubrics\": [\"flachwitz\", \"blondienenwitz\", \"kommentar\"]}", Joke.class);
		// categories remains `null`

		// Object --> JSON String (serialize)
		String json = gson.toJson(j);

		System.out.println(json);


		JokeResponse jr = gson.fromJson("{\"type\": \"success\", \"value\": " + json + "}", JokeResponse.class);

		String json1 = gson.toJson(jr);

		System.out.println(json1);


		String json20 = "{\"id\": 1, \"joke\": \"Haha du Opfer.\", \"rubrics\": [\"flachwitz\", \"schadenfreude\", \"kommentar\"]}";

		JokesResponse jsr = gson.fromJson("{\"type\": \"success\", \"value\": [" + json + ", " + json20 + "]}", JokesResponse.class);

		String json2 = gson.toJson(jsr);

		System.out.println(json2);




		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://api.icndb.com")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		ICNDBApi service = retrofit.create(ICNDBApi.class);


		//System.out.println(service.getRandomJoke());

		Call<JokeResponse> joke = service.getRandomJoke();

		JokeResponse s = joke.execute().body();

		System.out.println(s.getValue().getContent());
	}

}
