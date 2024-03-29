package paraverity.com.fintechproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {
	int request_Code = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// int testing = 1234;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		//nagivationview
		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		Button openBankAccount = (Button)findViewById(R.id.PersonalLoan);
		openBankAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), InputBankInfoActivity.class);
				startActivity(intent);
			}
		});

		ImageView accept1 = (ImageView)findViewById(R.id.dashboard_accept1);
		ImageView accept2 = (ImageView)findViewById(R.id.dashboard_accept2);
		ImageView cancel1 = (ImageView)findViewById(R.id.dashboard_cancel1);
		ImageView cancel2 = (ImageView)findViewById(R.id.dashboard_cancel2);

		accept1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ViewGroup parent = (ViewGroup) findViewById(R.id.linearCici).getParent();
				parent.removeView(findViewById(R.id.linearCici));
				Toast.makeText(DashboardActivity.this, "Cici's Request has been accepted!", Toast.LENGTH_LONG).show();
			}
		});
		cancel1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ViewGroup parent = (ViewGroup) findViewById(R.id.linearCici).getParent();
				parent.removeView(findViewById(R.id.linearCici));
				Toast.makeText(DashboardActivity.this, "Cici's Request has been rejected!", Toast.LENGTH_LONG).show();
			}
		});
		accept2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ViewGroup parent = (ViewGroup) findViewById(R.id.linearGuillaume).getParent();
				parent.removeView(findViewById(R.id.linearGuillaume));
				Toast.makeText(DashboardActivity.this, "Guillaume's Request has been accepted!", Toast.LENGTH_LONG).show();
			}
		});
		cancel2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ViewGroup parent = (ViewGroup) findViewById(R.id.linearGuillaume).getParent();
				parent.removeView(findViewById(R.id.linearGuillaume));
				Toast.makeText(DashboardActivity.this, "Guillaume's Request has been rejected!", Toast.LENGTH_LONG).show();
			}
		});
	}
	public void checkHistory (View view){
		startActivity(new Intent(this, CheckHistoryActivity.class));
	}
//	public void moreInfo (View view){
//		startActivityForResult(new Intent("com.example.cicijiang.myapp.ScrollingActivity"), request_Code);
//	}
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == request_Code){
			if(resultCode == RESULT_OK){
				Toast.makeText(this,data.getData().toString(),Toast.LENGTH_SHORT).show();

			}
		}
		if(requestCode == FindBankActivity.REQUEST_SELECT){
			if(resultCode == FindBankActivity.RESULT_SELECTED) {
				String bank = data.getStringExtra("bank_name");
				Toast.makeText(getApplicationContext(), "Your bank is " + bank, Toast.LENGTH_SHORT).show();
			}
		}
	}
	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			startActivity(new Intent(this, FriendListActivity.class));
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.navdrawer_citibank) {
			// Handle the camera action
		} else if (id == R.id.navdrawer_hsbc) {

		} else if (id == R.id.navdrawer_soge) {

		} else if (id == R.id.navdrawer_add_bank) {
			Intent i = new Intent(this, FindBankActivity.class);
			startActivityForResult(i, FindBankActivity.REQUEST_SELECT);
		} else if (id == R.id.navdrawer_logout) {
			finish();
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	public void startOpenBankAccount(View view){

	}
}
