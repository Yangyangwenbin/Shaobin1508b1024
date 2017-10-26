package baway.bawie.shaobin1508b1024.net;

import java.io.IOException;


public interface OnNetListener {
    public void onSuccess(Object o) throws IOException;
    public void onError(IOException e);
}
