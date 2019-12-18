package pavankreddy.blogspot.tabsfornavigation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewpager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.viewpager);
        ViewPagerAdapter vpa =
                new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(vpa);

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewpager);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "Red";
                case 1: return "Green";
                case 2: return "Blue";
            }
            return super.getPageTitle(position);
        }

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0:
                    return new RedFragment();
                case 1:
                    return new GreenFragment();
                case 2:
                    return new BlueFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
