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
	private boolean isChache=false;
	//private String message;
	private Response.Listener<InputStream> listener;
    public StreamRequest(int method,String url,Response.Listener<InputStream> listener,Response.ErrorListener erroListener){
		super(method,url,erroListener);
		this.listener = listener;
		
	}

	public void setIsChache(boolean isChache) {
		this.isChache = isChache;
	}

	public boolean isChache() {
		return isChache;
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
		//message = "Cache没创建";
		if(!(isChache)){
		return Response.success(is,null);
		}else{
		return Response.success(is,HttpHeaderParser.parseCacheHeaders(networkResponse));
		}
	}
	
    
    
}
