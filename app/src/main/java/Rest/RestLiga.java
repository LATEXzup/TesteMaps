package Rest;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 3/7/14.
 */
public class RestLiga extends AsyncTask<Void,Void,Void>{
   //url server
   public String _hostRest = "http://ligaapp-mobile.appspot.com/";

   //path service
   public String _serviceRest= "user/login";





    //metodo obrigatorio para o async
    @Override
    protected Void doInBackground(Void... params){
        Login("","");
        return null;
    }



    //Metod Login
    public HttpResponse Login(String user, String pass) {
        //create a new HttpClient
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(this._hostRest + this._serviceRest);
        try{
            //add your data
            List<NameValuePair> nameValuePairs =new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("username","liga_user"));
            nameValuePairs.add(new BasicNameValuePair("password","123123"));
            nameValuePairs.add(new BasicNameValuePair("db","h"));

            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


            //execute
            HttpResponse response = httpclient.execute(httppost);
            return response;

        } catch (IOException e){
            return null;
        }



    }

}
