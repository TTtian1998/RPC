package com.tzx.rpc.transport;

import com.tzx.rpc.Peer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description HTTP是建立TCP短链接
 */
public class HttpTransportClient implements TransportClient {
    private String url;
    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" +peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpURLConnection =(HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.connect();
            IOUtils.copy(data,httpURLConnection.getOutputStream());

            int resultCode = httpURLConnection.getResponseCode();
            if (resultCode == HttpURLConnection.HTTP_OK){
                return httpURLConnection.getInputStream();
            }else {
                return httpURLConnection.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void close() {

    }
}
