package com.example.impressionyang.imprecalculater;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.system.ErrnoException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by impression on 17-8-8.
 * 基本思路：将所有数字、小数点和运算符（“=”除外）先输入到字符串数组中，然后运算时先找出第一个“）”，再往前找第一个“（“
 * 就完成了第一个优先级，在以此类推完成优先级，乘除加减的优先级再额外控制。
 */

public class CalculaterFragment extends Fragment implements View.OnClickListener {

    Button btn_num_0, btn_num_1, btn_num_2, btn_num_3, btn_num_4, btn_num_5, btn_num_6, btn_num_7, btn_num_8, btn_num_9, btn_clear
            , btn_k_left, btn_k_right, btn_chu, btn_cheng, btn_jian, btn_jia, btn_dot, btn_del, btn_result;

    private String[] string_temp = new String[100], string_input = new String[100], string_calculate = new String[100];
    private int count_input = 0,key_result=0;
    private String tempNowString="",tempHistoryString="";
    private TextView mTextView_now;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView_now=getActivity().findViewById(R.id.text_now);
        setListener();
    }

    public void setListener() {

        btn_num_0 = getActivity().findViewById(R.id.id_num_0);
        btn_num_1 = getActivity().findViewById(R.id.id_num_1);
        btn_num_2 = getActivity().findViewById(R.id.id_num_2);
        btn_num_3 = getActivity().findViewById(R.id.id_num_3);
        btn_num_4 = getActivity().findViewById(R.id.id_num_4);
        btn_num_5 = getActivity().findViewById(R.id.id_num_5);
        btn_num_6 = getActivity().findViewById(R.id.id_num_6);
        btn_num_7 = getActivity().findViewById(R.id.id_num_7);
        btn_num_8 = getActivity().findViewById(R.id.id_num_8);
        btn_num_9 = getActivity().findViewById(R.id.id_num_9);
        btn_clear = getActivity().findViewById(R.id.id_clear);
        btn_k_left = getActivity().findViewById(R.id.id_k_left);
        btn_k_right = getActivity().findViewById(R.id.id_k_right);
        btn_chu = getActivity().findViewById(R.id.id_chu);
        btn_cheng = getActivity().findViewById(R.id.id_cheng);
        btn_jian = getActivity().findViewById(R.id.id_jian);
        btn_jia = getActivity().findViewById(R.id.id_jia);
        btn_dot = getActivity().findViewById(R.id.id_dot);
        btn_del = getActivity().findViewById(R.id.id_del);
        btn_result = getActivity().findViewById(R.id.id_result);


        btn_num_0.setOnClickListener(this);
        btn_num_1.setOnClickListener(this);
        btn_num_2.setOnClickListener(this);
        btn_num_3.setOnClickListener(this);
        btn_num_4.setOnClickListener(this);
        btn_num_5.setOnClickListener(this);
        btn_num_6.setOnClickListener(this);
        btn_num_7.setOnClickListener(this);
        btn_num_8.setOnClickListener(this);
        btn_num_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_k_left.setOnClickListener(this);
        btn_k_right.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_jia.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_result.setOnClickListener(this);




    }

    @Override
    public void onClick(View p1) {
        // TODO: Implement this method

        int v = p1.getId();
        switch (v) {
            case R.id.id_num_0:
                key_result=1;
                string_input[count_input] = "0";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_1:
                key_result=1;
                string_input[count_input] = "1";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_2:
                key_result=1;
                string_input[count_input] = "2";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_3:
                key_result=1;
                string_input[count_input] = "3";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_4:
                key_result=1;
                string_input[count_input] = "4";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_5:
                key_result=1;
                string_input[count_input] = "5";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_6:
                key_result=1;
                string_input[count_input] = "6";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_7:
                key_result=1;
                string_input[count_input] = "7";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_8:
                key_result=1;
                string_input[count_input] = "8";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_num_9:
                key_result=1;
                string_input[count_input] = "9";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_dot:
                key_result=1;
                string_input[count_input] = ".";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_jia:
                string_input[count_input] = "+";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_jian:
                string_input[count_input] = "-";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_cheng:
                string_input[count_input] = "*";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_chu:
                string_input[count_input] = "/";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_del:
                fuction_del(string_input,count_input);
                count_input--;
                break;
            case R.id.id_clear:
                count_input = 0;
                tempNowString="";
                tempHistoryString="";
                set_arry_default(string_input);
                set_screen_history("");
                set_screen_now("",1);
                break;
            case R.id.id_k_left:
                if(count_input==0){
                    string_input[count_input] = "(";
                    set_screen_now(string_input[count_input],1);
                    count_input++;
                }else if(string_input[count_input-1].equals("*")==false&&string_input[count_input-1].equals("/")==false&&string_input[count_input-1].equals("-")==false&&string_input[count_input-1].equals("+")==false ){
                    string_input[count_input] = "*";
                    count_input++;
                    string_input[count_input] = "(";
                    set_screen_now(string_input[count_input],1);
                    count_input++;
                }else{
                    string_input[count_input] = "(";
                    set_screen_now(string_input[count_input],1);
                    count_input++;
                }
                break;
            case R.id.id_k_right:
                string_input[count_input] = ")";
                set_screen_now(string_input[count_input],1);
                count_input++;
                break;
            case R.id.id_result:
                try{
                    double result=0;
                    if(key_result==1){
                        count_input--;
                        result=method_result(string_input);
                    }
                    key_result=0;
                    set_screen_history(tempNowString);
                    tempNowString="";
                    String temp=Double.toString(result);
                    set_screen_now(temp,1);
                    tempHistoryString="";
                    set_arry_default(string_input);
                    count_input=0;
                    if(result==0){
                        string_input[0]="0";
                    }else{
                        string_input[0]=Double.toString(result);
                        count_input++;
                    }
                    //Toast.makeText(getActivity(),Double.toString(result),Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                    count_input = 0;
                    tempNowString="";
                    tempHistoryString="";
                    set_arry_default(string_input);
                    set_screen_history("");
                    set_screen_now("",1);
                    Toast.makeText(getActivity(),"你的操作有误！",Toast.LENGTH_SHORT).show();
                } finally {}
                break;
            default:
                break;
        }
    }


    public void fuction_del(String Str_source[],int value){
        String Str_format="";
        try {
            for(int i=0;i<value-1;i++){
                Str_format+=Str_source[i].toString();
            }
            set_screen_now(Str_format,0);
            // Toast.makeText(getActivity(),Str_format,Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_SHORT).show();

        }
    }

    public void set_screen_now(String string_now,int key){
        if(key==0){
            tempNowString=string_now;
        }else{
            tempNowString+=string_now;
        }
        mTextView_now.setText(tempNowString);
    }

    public void set_screen_history(String string_history){
        TextView mTextView_now=getActivity().findViewById(R.id.text_history);
        tempHistoryString+=string_history;
        mTextView_now.setText(tempHistoryString);
    }


    public double method_result(String [] str_source){
        double result=0;
        int set_from,set_to,get_end=0;
        for(int i=0;i<=count_input;i++){
            if(str_source[i].equals(")")){
                str_source[i]="#";
                set_to=i;
                set_from=find_last_value(str_source,i);
                copy_set_value_temp(str_source,set_from+1,set_to-1);
                set_value_calculate();
                str_source[set_from]=Double.toString(get_result());
                for (int j=set_from+1;j<=set_to;j++){
                    str_source[j]="#";
                }
            }
            get_end++;
        }

        set_arry_default(string_temp);
        set_arry_default(string_calculate);
        copy_set_value_temp(str_source,0,get_end-1);
        set_value_calculate();
        result=get_result();

        return result;
    }

    public int find_last_value(String [] str,int dot_from){
        int dot_found=0;
        int key=1;
        for(int i=dot_from;key!=0;i--){
            if(str[i].equals("(")){
                dot_found=i;
                key=0;
                return dot_found;
            }
        }
        return dot_found;
    }


    /*
    * 此方法用于设置string_temp里面的有效数字；就是将分散的数字整合
    * */
    public void copy_set_value_temp(String [] str_cource,int set_from,int set_to){
        String temp="";
        int count=0;
        set_arry_default(string_temp);
        for(int i=set_from;i<=set_to;i++){
            if(str_cource[i].equals("+")||str_cource[i].equals("-")||str_cource[i].equals("*")||str_cource[i].equals("/")){
                string_temp[count-1]=temp;
                temp="";
                string_temp[count]=str_cource[i];
                count++;
            }else{
                if(str_cource[i].equals("#")==false){
                    temp+=str_cource[i];
                    string_temp[count]="#";
                    count++;
                }
            }
        }
        string_temp[count-1]=temp;
    }

    /*
    * 此方法用于设置string_calculate里面的有效数字；就是将string_temp的#去掉:
    * */
    public void set_value_calculate(){
        set_arry_default(string_calculate);
        int count=0;
        for(int i=0;string_temp[i]!=null;i++){
            if(string_temp[i].equals("#")==false){
                string_calculate[count]=string_temp[i];
                count++;
            }
        }
    }

    /*
    * 这个方法是用来找有效数字的，1是向后，0是向前;
    * */

    public int find_value_element(String [] str,int dot_from,int drection) {
        int key=1;
        int dot_found = 0;
        if (drection == 1) {
            for(int i=dot_from+1;key==1;i++){
                if(str[i].equals("#")==false){
                    dot_found=i;
                    key=0;
                    return dot_found;
                }
            }
        }

        if (drection == 0) {
            for(int i=dot_from-1;key==1;i--){
                if(str[i].equals("#")==false){
                    dot_found=i;
                    key=0;
                    return dot_found;
                }
            }
        }

        return dot_found;
    }


    /*
    * 这个方法是用来获取一个没有括号的运算时的结果的;
    * */
    public double get_result(){
        double result=0;
        for(int i=0;string_calculate[i]!=null;i++){
            if(string_calculate[i].equals("*")||string_calculate[i].equals("/")){
                if(string_calculate[i].equals("*")){
                    int last_value=find_value_element(string_calculate,i,0);
                    double temp=Double.valueOf(string_calculate[last_value])*Double.valueOf(string_calculate[i+1]);
                    string_calculate[i]=Double.toString(temp);
                    string_calculate[last_value]="#";
                    string_calculate[i+1]="#";
                }
                if(string_calculate[i].equals("/")){
                    int last_value=find_value_element(string_calculate,i,0);
                    double temp2=Double.valueOf(string_calculate[last_value])/Double.valueOf(string_calculate[i+1]);
                    string_calculate[i]=Double.toString(temp2);
                    string_calculate[last_value]="#";
                    string_calculate[i+1]="#";
                }
            }
        }

        for(int i=0;string_calculate[i]!=null;i++){
            if(string_calculate[i].equals("#")==false){
                if(string_calculate[i].equals("+")){
                    string_calculate[i]="#";
                }
                if(string_calculate[i].equals("-")){
                    string_calculate[i]="#";
                    double temp;
                    temp=Double.valueOf(string_calculate[i+1]);
                    string_calculate[i+1]=Double.toString(0-temp);
                }
            }
        }

        for(int i=0;string_calculate[i]!=null;i++){
            if(string_calculate[i].equals("#")==false){
                result+=Double.valueOf(string_calculate[i]);
            }
        }
        return result;
    }

    /*
    * 这个方法是用来初始化数组的
    * */
    public void set_arry_default(String [] str){
        for(int i=0;i<str.length;i++){
            str[i]=null;
        }
    }

}
