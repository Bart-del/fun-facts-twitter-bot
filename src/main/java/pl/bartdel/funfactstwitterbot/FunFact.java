package pl.bartdel.funfactstwitterbot;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


@Service
public class FunFact {

    static String hashtags = "\n#funfactsbot #imbot #programming ";

    public void getFact() throws Exception {
        while(true) {
            HttpResponse<JsonNode> httpResponse = Unirest.get("https://uselessfacts.jsph.pl/random.json?language=en")
                    .asJson();
            JSONObject object = httpResponse.getBody().getObject();
            String text = object.getString("text");
            postTweet(text);
            Thread.sleep(11520000);
        }

    }

    public void postTweet(String body) throws Exception{
        Passwords passwords = new Passwords();
        String consumerKey = passwords.getConsumerKeyStr();
        String consumerSecret = passwords.getConsumerSecretStr();
        String accessToken = passwords.getAccessTokenStr();
        String accessTokenSecret = passwords.getAccessTokenSecretStr();

        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey,consumerSecret);
        AccessToken ac = new AccessToken(accessToken,accessTokenSecret);
        twitter.setOAuthAccessToken(ac);
        twitter.updateStatus(body + hashtags);
        System.out.println("SUCCESSFUL");

    }


}
