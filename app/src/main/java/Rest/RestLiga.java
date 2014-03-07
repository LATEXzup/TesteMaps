package Rest;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
       // this.Login("","");
        return null;
    }



    //Metod Login
    public void Login(String user, String pass) {
        //create a new HttpClient
        HttpClient httpclient = new DefaultHttpClient();

        HttpPost httppost = new HttpPost(this._hostRest + this._serviceRest);
        httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json");

        try{
            //add your data

            try{
            JSONStringer TestApp = new JSONStringer().object().key("username").value("liga_user").key("password").value("123123").key("db").value("h").endObject();
                StringEntity entity = new StringEntity(TestApp.toString());
                httppost.setEntity(entity);

                Log.d("****Parameter Input****", "Testing:" + TestApp);
                //execute
                HttpResponse response = httpclient.execute(httppost);
                Log.d("WebInvoke", "Saving: " + response.getStatusLine().toString());
                // Get the status of web service

                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                // print status in log
                //String line = "";
               // while ((line = rd.readLine()) != null) {
                 //   Log.d("****Status Line***", "Webservice: " + line);

//                }

                String json = rd.readLine();
                JSONTokener tokener = new JSONTokener(json);
                JSONObject finalResult = new JSONObject(tokener);
                Log.d("erro no json",finalResult.toString());
            }catch (JSONException e)
            {
               Log.d("erro no json",e.getMessage());
                return;
            }




        }catch (ClientProtocolException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

}
