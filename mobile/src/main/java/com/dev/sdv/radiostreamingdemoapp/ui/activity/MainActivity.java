package com.dev.sdv.radiostreamingdemoapp.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import com.dev.sdv.radiostreamingdemoapp.R;
import com.dev.sdv.radiostreamingdemoapp.ui.view.MiniPlayer;

public class MainActivity extends BaseActivity {

  private BottomSheetBehavior behavior;
  private MiniPlayer miniPlayer;

  // Lifecycle methods

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  // Override methods

  @Override protected int getLayoutResourceId() {
    return R.layout.activity_main;
  }

  @Override protected void onCreateBase(Bundle savedInstanceState) {
    initViews();
  }

  // Other methods

  private void initViews(){
    initChannelsMenu();
    initBottomSheet();
    setupMiniPlayer();
  }

  private void initChannelsMenu(){
    Log.d(TAG, "Initialized channels menu");
    // TODO: implement channels menu
  }

  private void initBottomSheet(){
    // Initialize bottom sheet container with mini player inside it
    View bottomSheetView = findViewById(R.id.nsv_bottom_sheet);
    if(bottomSheetView != null){
      behavior = BottomSheetBehavior.from(bottomSheetView);
      Log.d(TAG, "Initialized Bottom sheet");
      if(behavior != null){
        Log.d(TAG, String.format("Bottom sheet initial height: %d", behavior.getPeekHeight()));
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        Log.d(TAG, String.format("Bottom sheet initial state: %s", behavior.getState()));
        //behavior.setBottomSheetCallback();
      }
    }
  }

  /**
   * Configures the mini player
   */
  private void setupMiniPlayer(){
    miniPlayer = new MiniPlayer(this);
    showMiniPlayer();
  }

  private boolean showMiniPlayer(){
    if(behavior != null){
      behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
      behavior.setHideable(false);
      return true;
    }
    return false;
  }

  private boolean hideMiniPlayer(){
    if(behavior != null){
      behavior.setHideable(true);
      behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
      return true;
    }
    return false;
  }
}