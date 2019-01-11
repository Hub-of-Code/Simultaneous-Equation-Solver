package com.example.zucky.simultaneousequationsolverv10;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity2 extends Activity {
    Button slv, clr;
    EditText a1,x1,b1,y1,c1,a2,x2,b2,y2,c2, ope1, ope2;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        slv = (Button) findViewById(R.id.solve);
        clr = (Button) findViewById(R.id.clear);
        a1 = (EditText) findViewById(R.id.a1);
        x1= (EditText) findViewById(R.id.x1);
        b1= (EditText)findViewById(R.id.b1);
        y1=(EditText) findViewById(R.id.y1);
        c1= (EditText) findViewById(R.id.c1);
        a2 = (EditText) findViewById(R.id.a2);
        x2= (EditText) findViewById(R.id.x2);
        b2= (EditText)findViewById(R.id.b2);
        y2=(EditText) findViewById(R.id.y2);
        c2= (EditText) findViewById(R.id.c2);
        ope1= (EditText) findViewById(R.id.Ope1);
        ope2= (EditText) findViewById(R.id.Ope2);
        txt = (TextView) findViewById(R.id.Solutions);
        slv.setOnClickListener(new View.OnClickListener(){
            String ooo1, ooo2;
            @Override
            public void onClick(View view){
                try{
                    txt.append(Html.fromHtml("<br>" + "_________________________________________"));
                    txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + " " + ope1.getText() + " " + b1.getText() + y1.getText() + " = " + c1.getText() + "  ---- (1)" + "</br>"));
                    txt.append(Html.fromHtml("<br> " + a2.getText() + x2.getText() + " " + ope2.getText() + " " + b2.getText() + y2.getText() + " = " + c2.getText() + "  ---- (2)" + "</br>"));
                    if (a1.getText().toString().equals("")){
                        a1.setText("1");
                    }
                    if (b1.getText().toString().equals("")){
                        b1.setText("1");
                    }
                    if (b2.getText().toString().equals("")){
                        b2.setText("1");
                    }
                    if (a2.getText().toString().equals("")){
                        a2.setText("1");
                    }
                    String xx1 = (ope1.getText().toString()) + (b1.getText().toString());
                    String xx2 = (ope2.getText().toString()) + (b2.getText().toString());
                    String a = a1.getText().toString();
                    String b = a2.getText().toString();
                    if (a.equals(b)){
                        if (Double.parseDouble(xx1)!=Double.parseDouble(xx2)) {
                            Double s1 = Double.parseDouble(xx1);
                            Double s2 = Double.parseDouble(xx2);
                            Double s3 = s2 - s1;
                            Double t1 = Double.parseDouble(c1.getText().toString());
                            Double t2 = Double.parseDouble(c2.getText().toString());
                            Double t3 = t2-t1;
                            txt.append(Html.fromHtml("<br>" + "Subtract Equation (1) from Equation (2)" + "</br>"));
                            txt.append(Html.fromHtml("<br>" + s3 + y1.getText().toString()  + " = " + t3 + "" + "</br>"));
                            txt.append(Html.fromHtml("<br>" + y1.getText().toString() + " = " + t3 + " / " + s3 + "</br>"));
                            txt.append(Html.fromHtml("<br>" + y1.getText().toString() + " = " + (double)Math.round((t3/s3)*100d)/100d +"</br>"));
                            Double ans1 = (double)Math.round((t3/s3)*100d)/100d;
                            txt.append(Html.fromHtml("<br>" + "Substitute " + y1.getText().toString() + " into Equation (1)" + "</br>"));
                            txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + " " + ope1.getText() + " " + b1.getText() + y1.getText() + " = " + c1.getText()  + "</br>"));
                            Double subs = (double)Math.round((t3/s3)*100d)/100d;
                            txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + " " + ope1.getText() + " " + b1.getText() + " (" + subs + ")" + " = " + c1.getText()  + "</br>"));
                            Double m1 = (double)Math.round((s1 * subs)*100d)/100d;
                            String ch1 = m1 + "";
                            if (ch1.contains("-")){
                                Double m2 = m1 * -1;
                                String ch3= " + " + m2;
                                String ch2 = " - " + m2;
                                txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + ch2 + " = " + c1.getText() + "</br>"));
                                txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + " = " + c1.getText() + ch3 + "</br>"));
                                Double h1 = Double.parseDouble(c1.getText().toString());
                                Double h2 = (double)Math.round((h1 + m2)*100d)/100d;
                                txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText()  + " = " + h2 + "</br>"));
                                txt.append(Html.fromHtml("<br> " + x1.getText()  + " = " + h2 + " / " + a1.getText().toString() + "</br>"));
                                Double k1 = Double.parseDouble(a1.getText().toString());
                                Double ans = (double)Math.round((h2 /k1)*100d)/100d;
                                txt.append(Html.fromHtml("<br>" + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "      and; " + y1.getText() + " = " + ans1 + "</br>"));
                            }
                            else
                            {
                                String ch2 = " + " + m1;
                                Double m2 = m1 * -1;
                                String ch3= " - " + m1;
                                txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + ch2 + " = " + c1.getText()  + "</br>"));
                                txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText()  + " = " + c1.getText() + ch3 + "</br>"));
                                Double h1 = Double.parseDouble(c1.getText().toString());
                                Double h2 =  (double)Math.round((h1 + m2)*100d)/100d;
                                txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText()  + " = " + h2 + "</br>"));
                                txt.append(Html.fromHtml("<br> " + x1.getText()  + " = " + h2 + " / " + a1.getText().toString() + "</br>"));
                                Double k1 = Double.parseDouble(a1.getText().toString());
                                Double ans = (double)Math.round((h2 /k1)*100d)/100d;
                                txt.append(Html.fromHtml("<br>" + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "      and; " + y1.getText() + " = " + ans1 + "</br>"));
                            }
                        }
                    }
                    if (xx1.equals(xx2)) {
                        if (Double.parseDouble(a) != Double.parseDouble(b)) {
                            Double s1 = Double.parseDouble(a1.getText().toString());
                            Double s2 = Double.parseDouble(a2.getText().toString());
                            Double s3 = s2 - s1;
                            Double t1 = Double.parseDouble(c1.getText().toString());
                            Double t2 = Double.parseDouble(c2.getText().toString());
                            Double t3 = t2 - t1;
                            txt.append(Html.fromHtml("<br>" + "Subtract Equation (1) from Equation (2)" + "</br>"));
                            txt.append(Html.fromHtml("<br>" + s3 + x1.getText() + " = " + t3 + "</br>"));
                            txt.append(Html.fromHtml("<br>" + x1.getText() + " = " + t3 + " / " + s3));
                            txt.append(Html.fromHtml("<br>" + x1.getText() + " = " + (double) Math.round((t3 / s3) * 100d) / 100d + "</br>"));
                            txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + (double) Math.round((t3 / s3) * 100d) / 100d + "</br>"));
                            Double ans1 = (double) Math.round((t3 / s3) * 100d) / 100d;
                            txt.append(Html.fromHtml("<br>" + "Substitute " + x1.getText().toString() + " into Equation (1)" + "</br>"));
                            txt.append(Html.fromHtml("<br> " + a1.getText() + x1.getText() + " " + ope1.getText() + " " + b1.getText() + y1.getText() + " = " + c1.getText() + "</br>"));
                            txt.append(Html.fromHtml("<br>" + a1.getText() + " (" + ans1 + ") " + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + c1.getText().toString() + "</br>"));
                            Double m1 = (double) Math.round((s1 * ans1) * 100d) / 100d;
                            String ch1 = m1 + "";
                            if (ch1.contains("-")) {
                                Double m2 = m1 * -1;
                                String ch2 = "-" + m2;
                                String ch3 = " + " + m2;
                                txt.append(Html.fromHtml("<br>" + ch2 + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + c1.getText().toString() + "</br>"));
                                txt.append(Html.fromHtml("<br>" + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + c1.getText().toString() + ch3 + "</br>"));
                                Double h1 = Double.parseDouble(c1.getText().toString());
                                Double h2 = (double) Math.round((h1 + m2) * 100d) / 100d;
                                txt.append(Html.fromHtml("<br>" + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + h2 + "</br>"));
                                txt.append(Html.fromHtml("<br>" + y1.getText() + " = " + h2 + " / " + b1.getText() + "</br>"));
                                Double k1 = Double.parseDouble(b1.getText().toString());
                                Double ans = (double) Math.round((h2 / k1) * 100d) / 100d;
                                txt.append(Html.fromHtml("<br>" + y1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "      and; " + y1.getText() + " = " + ans1 + "</br>"));
                            } else {
                                String ch2 = "" + m1;
                                txt.append(Html.fromHtml("<br>" + ch2 + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + c1.getText().toString() + "</br>"));
                                Double m2 = m1 * -1;
                                String ch3 = " - " + m1;
                                txt.append(Html.fromHtml("<br>" + ch2 + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + c1.getText().toString() + "</br>"));
                                txt.append(Html.fromHtml("<br>" + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + c1.getText().toString() + ch3 + "</br>"));
                                Double h1 = Double.parseDouble(c1.getText().toString());
                                Double h2 = (double) Math.round((h1 + m2) * 100d) / 100d;
                                txt.append(Html.fromHtml("<br>" + ope1.getText().toString() + b1.getText().toString() + y1.getText() + " = " + h2 + "</br>"));
                                txt.append(Html.fromHtml("<br>" + y1.getText() + " = " + h2 + " / " + b1.getText() + "</br>"));
                                Double k1 = Double.parseDouble(b1.getText().toString());
                                Double ans = (double) Math.round((h2 / k1) * 100d) / 100d;
                                txt.append(Html.fromHtml("<br>" + y1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "      and; " + y1.getText() + " = " + ans1 + "</br>"));
                            }
                        }
                    }
                    if (Double.parseDouble(a1.getText().toString())!=Double.parseDouble(a2.getText().toString())){
                        if (Double.parseDouble(xx1) !=Double.parseDouble(xx2)) {
                            txt.append(Html.fromHtml("<br>" + "Multiply Equation (1) by " + a2.getText() + " and Equation (2) by " + a1.getText() + "</br>"));
                            Double a_1 = Double.parseDouble(a1.getText().toString());
                            Double b_1 = Double.parseDouble(b1.getText().toString());
                            Double c_1 = Double.parseDouble(c1.getText().toString());
                            Double a_2 = Double.parseDouble(a2.getText().toString());
                            Double b_2 = Double.parseDouble(b2.getText().toString());
                            Double c_2 = Double.parseDouble(c2.getText().toString());
                            Double mul = b_1 * a_2;
                            String mm = mul + "";
                            if (mm.contains("-")) {
                                Double lm = Double.parseDouble(mm);
                                lm =lm*-1;
                                mm =lm + "";
                                mm = " - " + mm;
                                ooo1="-";
                            } else{
                                mm = " + " + mm;
                                ooo1="+";
                            }
                            Double ama = a_1*a_2;
                            Double amc = c_1*a_2;
                            txt.append(Html.fromHtml("<br>" + ama+ x1.getText().toString() + mm  + y1.getText() + " = " + amc + " --- (3)" + "</br>"));
                            Double mul2 = b_2 * a_1;
                            String m2 = mul2 + "";
                            if (m2.contains("-")) {
                                Double lm = Double.parseDouble(mm);
                                lm =lm*-1;
                                m2 =lm + "";
                                m2 = " - "+ m2;
                                ooo2="-";
                            } else{
                                m2 = " + " + m2;
                                ooo2="+";
                            }
                            Double ama2 = a_2*a_1;
                            Double amc2 = c_2*a_1;
                            txt.append(Html.fromHtml("<br>" + ama2+ x1.getText().toString() + m2  + y1.getText() + " = " + amc2 + " --- (4)" + "</br>"));
                            xx1 = mm.replace(" ","");
                            xx2 = m2.replace(" ","");
                            String aaa1,xxx1,bbb1,yyy1,ccc1;
                            aaa1= a_1 + "";
                            xxx1= x1.getText().toString();
                            bbb1= b_1 + "";
                            yyy1= y1.getText().toString();
                            ccc1= c_1 + "";
                            Double ss1 = Double.parseDouble(xx1);
                            Double ss2 = Double.parseDouble(xx2);
                            Double ss3 = ss2 - ss1;
                            Double tt3 = amc2-amc;
                            txt.append(Html.fromHtml("<br>" + "Subtract Equation (3) from Equation (4)" + "</br>"));
                            txt.append(Html.fromHtml("<br>" + ss3 + y1.getText().toString()  + " = " + tt3 + "" + "</br>"));
                            txt.append(Html.fromHtml("<br>" + y1.getText().toString() + " = " + tt3 + " / " + ss3 + "</br>"));
                            txt.append(Html.fromHtml("<br>" + y1.getText().toString() + " = " + (double)Math.round((tt3/ss3)*100d)/100d +"</br>"));
                            Double anss1 = (double)Math.round((tt3/ss3)*100d)/100d;
                            txt.append(Html.fromHtml("<br>" + "Substitute " + yyy1 + " into Equation (3)" + "</br>"));
                            txt.append(Html.fromHtml("<br> " + aaa1 + x1.getText() + " " + ooo1 + " " + bbb1 + y1.getText() + " = " + ccc1 + "</br>"));
                            Double subs = (double)Math.round((tt3/ss3)*100d)/100d;
                            txt.append(Html.fromHtml("<br> " + aaa1 + x1.getText() + " " + ooo1 + " " + bbb1+ " (" + subs + ")" + " = " + ccc1  + "</br>"));
                            Double mm1 = (double)Math.round((Double.parseDouble(bbb1) * subs)*100d)/100d;
                            String chh1 = mm1 + "";
                            if (chh1.contains("-")){
                                Double mm2 = mm1 * -1;
                                String ch3= " + " + mm2;
                                String ch2 = " - " + mm2;
                                txt.append(Html.fromHtml("<br> " + aaa1 + x1.getText() + ch2 + " = " + ccc1 + "</br>"));
                                txt.append(Html.fromHtml("<br> " + aaa1 + x1.getText() + " = " + ccc1 + ch3 + "</br>"));
                                Double h1 = Double.parseDouble(ccc1);
                                Double h2 = (double)Math.round((h1 + mm2)*100d)/100d;
                                txt.append(Html.fromHtml("<br> " + aaa1 + x1.getText()  + " = " + h2 + "</br>"));
                                txt.append(Html.fromHtml("<br> " + x1.getText()  + " = " + h2 + " / " + aaa1 + "</br>"));
                                Double k1 = Double.parseDouble(aaa1);
                                Double ans = (double)Math.round((h2 /k1)*100d)/100d;
                                txt.append(Html.fromHtml("<br>" + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "      and; " + y1.getText() + " = " + anss1 + "</br>"));
                            }
                            else
                            {
                                String ch2 = " + " + mm1;
                                Double mm2 = mm1 * -1;
                                String ch3= " - " + mm1;
                                txt.append(Html.fromHtml("<br> " + aaa1+ xxx1 + ch2 + " = " + ccc1  + "</br>"));
                                txt.append(Html.fromHtml("<br> " + aaa1 + xxx1  + " = " + ccc1 + ch3 + "</br>"));
                                Double h1 = Double.parseDouble(ccc1);
                                Double h2 =  (double)Math.round((h1 + mm2)*100d)/100d;
                                txt.append(Html.fromHtml("<br> " + aaa1 + x1.getText()  + " = " + h2 + "</br>"));
                                txt.append(Html.fromHtml("<br> " + x1.getText()  + " = " + h2 + " / " + aaa1 + "</br>"));
                                Double k1 = Double.parseDouble(aaa1);
                                Double ans = (double)Math.round((h2 /k1)*100d)/100d;
                                txt.append(Html.fromHtml("<br>" + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "Therefore; " + x1.getText() + " = " + ans + "</br>"));
                                txt.append(Html.fromHtml("<br>" + "      and; " + y1.getText() + " = " + anss1 + "</br>"));
                            }
                        }
                    }
                }
                catch(Exception e) {
                    Toast.makeText(MainActivity2.this, "Please Confirm your input and try again", Toast.LENGTH_LONG).show();
                }
            }

        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                txt.setText("");
                a1.setText("");
                x1.setText("");
                b1.setText("");
                y1.setText("");
                c1.setText("");
                a2.setText("");
                x2.setText("");
                b2.setText("");
                y2.setText("");
                c2.setText("");
                ope1.setText("+");
                ope1.setText("+");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
