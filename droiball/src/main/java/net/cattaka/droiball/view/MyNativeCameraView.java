
package net.cattaka.droiball.view;

import android.content.Context;
import android.util.AttributeSet;

import org.opencv.android.NativeCameraView;
import org.opencv.core.Size;
import org.opencv.highgui.VideoCapture;

import java.util.List;

public class MyNativeCameraView extends NativeCameraView {
    private Size mPreviewSize;

    public MyNativeCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNativeCameraView(Context context, int cameraId) {
        super(context, cameraId);
    }

    public void setPreviewSize(Size previewSize) {
        mPreviewSize = previewSize;
    }

    @Override
    protected boolean connectCamera(int width, int height) {
        if (super.connectCamera(width, height)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected Size calculateCameraFrameSize(List<?> supportedSizes, ListItemAccessor accessor,
            int surfaceWidth, int surfaceHeight) {
        if (mPreviewSize != null) {
            return mPreviewSize;
        } else {
            return super.calculateCameraFrameSize(supportedSizes, accessor, surfaceWidth,
                    surfaceHeight);
        }
    }

    public VideoCapture getVideoCapture() {
        return mCamera;
    }

    public void setCameraId(int id) {
        mCameraIndex = id;
    }
}
