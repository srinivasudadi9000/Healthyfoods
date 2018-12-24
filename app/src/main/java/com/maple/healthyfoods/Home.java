package com.maple.healthyfoods;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class Home extends Activity implements View.OnClickListener {
    ImageView profile_img, settings_img, food_img, table_img, menu;
    LinearLayout foodorders, tablebookings, accountsetting, foodlist, settingslist, tables_list;
    ScrollView scroll;

    DrawerLayout home;
    CardView myycard;
    private ArrayList<SectionDataModel> allSampleData;
    ArrayList<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        profile_img = findViewById(R.id.profile_img);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.srinivasu);
        profile_img.setImageBitmap(getCircleBitmap(icon));

        myycard = findViewById(R.id.myycard);
        home = (DrawerLayout) findViewById(R.id.drawer_id);
        menu = findViewById(R.id.menu_img);
        menu.setOnClickListener(this);
        foodorders = findViewById(R.id.foodorders);
        tablebookings = findViewById(R.id.tablebookings);
        accountsetting = findViewById(R.id.accountsetting);

        foodlist = findViewById(R.id.foodlist);
        settingslist = findViewById(R.id.settingslist);
        tables_list = findViewById(R.id.tables_list);
        scroll = findViewById(R.id.scroll);

        settings_img = findViewById(R.id.settings_img);
        food_img = findViewById(R.id.food_img);
        table_img = findViewById(R.id.table_img);

        foodorders.setOnClickListener(this);
        tablebookings.setOnClickListener(this);
        accountsetting.setOnClickListener(this);

        foodlist.setOnClickListener(this);
        settingslist.setOnClickListener(this);
        tables_list.setOnClickListener(this);

        allSampleData = new ArrayList<>();

        categories = new ArrayList<>();
        categories.add("Go out for lunch or dinner");
        categories.add("Get food delivered");
        categories.add("Get inspired by collections");
        categories.add("Cafes");
        categories.add("Explore your favorite cuisines");
        categories.add("Popular brands");
        createDummyData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(allSampleData, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void createDummyData() {
        for (int i = 0; i <= 5; i++) {
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle(categories.get(i).toString());
            dm.setIndex(i);
            ArrayList<SingleItemModel> singleItemModels = new ArrayList<>();
            switch (i) {
                case 0:
                    singleItemModels.add(new SingleItemModel("3.0", "Food Ex ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("3.0", "AK's Taste Well Fast ", "Dwaraka Nagar, Vizag,Chinese , North Indian", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Vegetariean.. ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Specials", "Allipuram,vizag,South Indian", ""));
                    singleItemModels.add(new SingleItemModel("3.5", "7 Biriyanis ", "Waltair uplands,vizag Biriyanis", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "R-G - Hotel Greenpark ", "Hotel greenpark vizag , NOrth Indian, chinese", ""));
                    break;
                case 1:
                    singleItemModels.add(new SingleItemModel("3.0", "Konaseema Ruchulu ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("3.0", "The Gallery ", "Dwaraka Nagar, Vizag,Chinese , North Indian", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Sri Sairam Palour ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Alpha Hotel", "Allipuram,vizag,South Indian", ""));
                    singleItemModels.add(new SingleItemModel("3.5", "7 Biriyanis ", "Waltair uplands,vizag Biriyanis", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Visakha", "Hotel greenpark vizag , NOrth Indian, chinese", ""));
                    break;
                case 2:
                    singleItemModels.add(new SingleItemModel("3.0", "Must-visit  ", "restaurants in 12 places", ""));
                    singleItemModels.add(new SingleItemModel("3.0", "Greate Cafes ", "Dwaraka Nagar, Vizag,Chinese , North Indian", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ice Cream ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Sea View", "Allipuram,vizag,South Indian", ""));
                    singleItemModels.add(new SingleItemModel("3.5", "Luxury Dining ", "Waltair uplands,vizag Biriyanis", ""));
                    break;
                case 3:
                    singleItemModels.add(new SingleItemModel("3.0", "Food Ex ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("3.0", "AK's Taste Well Fast ", "Dwaraka Nagar, Vizag,Chinese , North Indian", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Vegetariean.. ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Specials", "Allipuram,vizag,South Indian", ""));
                    singleItemModels.add(new SingleItemModel("3.5", "7 Biriyanis ", "Waltair uplands,vizag Biriyanis", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "R-G - Hotel Greenpark ", "Hotel greenpark vizag , NOrth Indian, chinese", ""));
                    break;
                case 4:
                    singleItemModels.add(new SingleItemModel("3.0", "Food Ex ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("3.0", "AK's Taste Well Fast ", "Dwaraka Nagar, Vizag,Chinese , North Indian", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Vegetariean.. ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Specials", "Allipuram,vizag,South Indian", ""));
                    singleItemModels.add(new SingleItemModel("3.5", "7 Biriyanis ", "Waltair uplands,vizag Biriyanis", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "R-G - Hotel Greenpark ", "Hotel greenpark vizag , NOrth Indian, chinese", ""));
                    break;
                case 5:
                    singleItemModels.add(new SingleItemModel("3.0", "Food Ex ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("3.0", "AK's Taste Well Fast ", "Dwaraka Nagar, Vizag,Chinese , North Indian", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Vegetariean.. ", "asilmetta,vizag Fast food , Desserts", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "Ramaiah Specials", "Allipuram,vizag,South Indian", ""));
                    singleItemModels.add(new SingleItemModel("3.5", "7 Biriyanis ", "Waltair uplands,vizag Biriyanis", ""));
                    singleItemModels.add(new SingleItemModel("4.0", "R-G - Hotel Greenpark ", "Hotel greenpark vizag , NOrth Indian, chinese", ""));
                    break;

            }

            dm.setAllItemInSection(singleItemModels);
            allSampleData.add(dm);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_img:
                home.openDrawer(myycard);
                break;
            case R.id.foodorders:
                if (foodlist.getVisibility() == View.VISIBLE) {
                    foodlist.setVisibility(View.GONE);
                    food_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                } else {
                    food_img.setImageDrawable(getResources().getDrawable(R.drawable.remove_circle));
                    ViewAnimationUtils.expand(foodlist);
                    foodlist.setVisibility(View.VISIBLE);
                }
                settingslist.setVisibility(View.GONE);
                tables_list.setVisibility(View.GONE);
                table_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                settings_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                break;
            case R.id.tablebookings:
                if (tables_list.getVisibility() == View.VISIBLE) {
                    tables_list.setVisibility(View.GONE);
                    table_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                } else {
                    table_img.setImageDrawable(getResources().getDrawable(R.drawable.remove_circle));
                    ViewAnimationUtils.expand(tables_list);
                    tables_list.setVisibility(View.VISIBLE);

                }
                foodlist.setVisibility(View.GONE);
                settingslist.setVisibility(View.GONE);
                settings_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                food_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                break;
            case R.id.accountsetting:
                if (settingslist.getVisibility() == View.VISIBLE) {
                    scroll.fullScroll(scroll.FOCUS_UP);
                    settingslist.setVisibility(View.GONE);
                    settings_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                } else {
                    settings_img.setImageDrawable(getResources().getDrawable(R.drawable.remove_circle));
                    scroll.fullScroll(scroll.FOCUS_DOWN);
                    ViewAnimationUtils.expand(settingslist);
                    settingslist.setVisibility(View.VISIBLE);
                }
                tables_list.setVisibility(View.GONE);
                foodlist.setVisibility(View.GONE);

                food_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));
                table_img.setImageDrawable(getResources().getDrawable(R.drawable.add_circle));

                break;
        }

    }

    private Bitmap getCircleBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }


}
