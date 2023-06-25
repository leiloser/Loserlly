package volly;
import com.android.volley.Request;
import java.util.stream.Stream;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import com.android.volley.toolbox.HttpHeaderParser;

public class StreamRequest extends Request<InputStream> {
   /*
       time:@2023.6.25
       author:@leiloser
       qq:@2913141342
       QQ-GROU(QQ交流群):@805165262
       */
      // 此源码由Android官方提供,StreamRequest.java和StreamRequest.class由我一人编写
      //开源且免费，谢谢支持
   
	private String message;
	private Response.Listener<InputStream> listener;
    public StreamRequest(int method,String url,Response.Listener<InputStream> listener,Response.ErrorListener erroListener){
		super(method,url,erroListener);
		this.listener = listener;
		
	}
	
	@Override
	protected void deliverResponse(InputStream t) {
		if(listener==null){return;}
		
		listener.onResponse(t);
	}

	@Override
	protected Response<InputStream> parseNetworkResponse(NetworkResponse networkResponse) {
		InputStream is;
		is = new ByteArrayInputStream(networkResponse.data);
		message = "cCache没创建";
		
		return Response.success(is,null);
		
	}
	
    
    public String getMessage(){
		
		return message;
	}
    
}
