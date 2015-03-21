
package net.cattaka.droiball;

import net.cattaka.droiball.db.DroiballDatabase;
import net.cattaka.droiball.util.MyPreference;
import net.cattaka.libgeppa.IPassiveGeppaService;

import org.opencv.samples.fd.DetectionBasedTracker;

public interface IAppStub {
    public IPassiveGeppaService getGeppaService();

    public DroiballDatabase getDroiballDatabase();

    public DetectionBasedTracker getNativeDetector();

    public MyPreference getMyPreference();
}
