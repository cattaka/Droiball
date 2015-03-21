
package net.cattaka.droiball;

import android.content.ServiceConnection;

import net.cattaka.libgeppa.data.ConnectionState;
import net.cattaka.libgeppa.data.PacketWrapper;

public interface IAppListener extends ServiceConnection {

    public void onConnectionStateChanged(ConnectionState state);

    public void onReceivePacket(PacketWrapper packetWrapper);

    public void onPageSelected();

    public void onPageDeselected();
}
