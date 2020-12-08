package id.go.deliserdangkab.smartdels.panoramagl;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.panoramagl.PLImage;
import com.panoramagl.PLSpherical2Panorama;
import com.panoramagl.PLView;
import com.panoramagl.utils.PLUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends PLView {

    private Target mTarget;
    PLSpherical2Panorama panorama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        panorama = new PLSpherical2Panorama();
        mTarget = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                if (bitmap == null) {
                    Log.d("OKE", "NULL");
                } else {
                    Log.d("OKE", "BEKERJA");
                    panorama.setImage(new PLImage(bitmap, false));
                }
            }
            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Log.d("OKE", "gagal");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Log.d("OKE", "persiapan");
            }
        };
        Picasso.get().load("https://covid19.deliserdangkab.go.id/wp-content/gambaramal.jpg").into(mTarget);
        this.setPanorama(panorama);
    }
}