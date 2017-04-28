package doctor.fresh.com.freshdoctor.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by wei.he on 17/4/27.
 */

public class BannerViewPager extends PagerAdapter {

    private List<ImageView> imageViewList;

    public BannerViewPager(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        container.addView(imageViewList.get(position));
        return imageViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        container.removeView(imageViewList.get(position));
    }
}
