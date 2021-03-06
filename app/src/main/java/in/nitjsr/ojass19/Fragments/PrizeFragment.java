package in.nitjsr.ojass19.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import in.nitjsr.ojass19.Activity.HomeActivity;
import in.nitjsr.ojass19.Activity.SubEventsActivity;
import in.nitjsr.ojass19.Modals.EventModel;
import in.nitjsr.ojass19.Modals.PrizeModel1;
import in.nitjsr.ojass19.Modals.PrizeModel2;
import in.nitjsr.ojass19.R;
import in.nitjsr.ojass19.Utils.BtmNavVisCallback;


public class PrizeFragment extends Fragment {
    private LinearLayout prize_layout;
    private BtmNavVisCallback mCallback;
    private TextView prize1,prize2,prize3,prize4,prize5,prize6,prizeT,prize1_F,prize2_F,prize3_F,prize1_S,prize2_S,prize3_S,prize1_Th,prize2_Th,prize3_Th;
    private LinearLayout first,second,third,fourth,fifth,sixth,director_cut_layout,no_ground_zone_layout;
    private LinearLayout first_first,first_second,first_third,second_first,second_second,second_third,third_first,third_second,third_third;
    private TextView text_firstyear,text_secondyear,text_thirdyear;
    private TextView note_nscet;
    private int first_T=0,second_T=0,third_T=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        for(EventModel em: HomeActivity.data){
            if(em.getName()!=null){
                if(em.getName().compareToIgnoreCase(SubEventsActivity.event_name)==0){
                    //check type event
                    if(checkLayout(em.getName())) {
                        view = inflater.inflate(R.layout.fragment_prize1, container, false);
                        init1(view);
                        setData1(em);
                    }else{
                        view = inflater.inflate(R.layout.fragment_prize2, container, false);
                        init2(view);
                        setData2(em);
                    }
                    prize_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mCallback.onCallback();
                        }
                    });
                }
            }
        }

        return view;
    }
    boolean checkLayout(String name){
        if((name.compareToIgnoreCase("embetrix")==0 ) ||
                (name.compareToIgnoreCase("High Voltage Concepts")==0) ||
                (name.compareToIgnoreCase("electrospection")==0) ||
                (name.compareToIgnoreCase("Electro Scribble")==0) ||
                (name.compareToIgnoreCase("matsim")==0) ||
                (name.compareToIgnoreCase("Pro-Lo-Co")==0) ||
                (name.compareToIgnoreCase("Hack-De-Science")==0) ||
                (name.compareToIgnoreCase("agnikund")==0) ||
                (name.compareToIgnoreCase("knockout")==0)
        ){
            return false;
        }
        return true;
    }
    void setData1(EventModel em){
        if(em.getName().compareToIgnoreCase("Director's Cut")==0){
            director_cut_layout.setVisibility(View.VISIBLE);
            no_ground_zone_layout.setVisibility(View.GONE);
            note_nscet.setVisibility(View.GONE);
        }else if(em.getName().compareToIgnoreCase("Touch Down the plane")==0){
            no_ground_zone_layout.setVisibility(View.VISIBLE);
            director_cut_layout.setVisibility(View.GONE);
            note_nscet.setVisibility(View.GONE);
        }else if(em.getName().compareToIgnoreCase("NSCET")==0){
            note_nscet.setVisibility(View.VISIBLE);
            no_ground_zone_layout.setVisibility(View.GONE);
            director_cut_layout.setVisibility(View.GONE);

        }else{
            note_nscet.setVisibility(View.GONE);
            no_ground_zone_layout.setVisibility(View.GONE);
            director_cut_layout.setVisibility(View.GONE);
        }
        PrizeModel1 p1 = em.getP1();
        if(p1.getPrize1()!=null && p1.getPrize1()!=Long.valueOf(0)) {
            prize1.setText(String.valueOf(p1.getPrize1()));
            first.setVisibility(View.VISIBLE);

        }
        else{
            first.setVisibility(View.GONE);
        }
        if(p1.getPrize2()!=null && p1.getPrize2()!=Long.valueOf(0)) {
            prize2.setText(String.valueOf(p1.getPrize2()));
            second.setVisibility(View.VISIBLE);

        }else{
            second.setVisibility(View.GONE);
        }
        if(p1.getPrize3()!=null && p1.getPrize3()!=Long.valueOf(0)) {
            prize3.setText(String.valueOf(p1.getPrize3()));
            third.setVisibility(View.VISIBLE);
        }else{
            third.setVisibility(View.GONE);
        }
        if(p1.getPrize4()!=null && p1.getPrize4()!=Long.valueOf(0)) {
            prize4.setText(String.valueOf(p1.getPrize4()));
            fourth.setVisibility(View.VISIBLE);
        }else{
            fourth.setVisibility(View.GONE);
        }
        if(p1.getPrize5()!=null && p1.getPrize5()!=Long.valueOf(0)) {
            prize5.setText(String.valueOf(p1.getPrize5()));
            fifth.setVisibility(View.VISIBLE);
        }else{
            fifth.setVisibility(View.GONE);
        }
        if(p1.getPrize6()!=null && p1.getPrize6()!=Long.valueOf(0)) {
            prize6.setText(String.valueOf(p1.getPrize6()));
            sixth.setVisibility(View.VISIBLE);
        }else{
            sixth.setVisibility(View.GONE);
        }
        if(em.getName().compareToIgnoreCase("Digizone")==0 ||
                em.getName().compareToIgnoreCase("Analog Hunter")==0 ||
                em.getName().compareToIgnoreCase("Netkraft")==0 ){
            first_first.setVisibility(View.VISIBLE);
            text_firstyear.setVisibility(View.VISIBLE);
            prize1_F.setVisibility(View.VISIBLE);
        }else{
            first_first.setVisibility(View.GONE);
            text_firstyear.setVisibility(View.GONE);
            prize1_F.setVisibility(View.GONE);
        }
        prizeT.setText(String.valueOf(p1.getPrizeT()));
    }

    void setData2(EventModel em){
        if(em.getName().compareToIgnoreCase("Hack-De-Science")==0){
            text_firstyear.setText("App");
            text_secondyear.setText("Web");
            text_thirdyear.setText("Others");
        }else{
            text_firstyear.setText("First Year");
            text_secondyear.setText("Second Year");
            text_thirdyear.setText("Third Year");
        }
        PrizeModel2 p2 = em.getP2();
        if(p2.getPrize1_F()!=null && p2.getPrize1_F()!=Long.valueOf(0)) {
            prize1_F.setText(String.valueOf(p2.getPrize1_F()));
            first_first.setVisibility(View.VISIBLE);
            first_T+=p2.getPrize1_F();
        }else{
            first_first.setVisibility(View.GONE);
        }
        if(p2.getPrize2_F()!=null && p2.getPrize2_F()!=Long.valueOf(0)) {
            prize2_F.setText(String.valueOf(p2.getPrize2_F()));
            second_first.setVisibility(View.VISIBLE);
            first_T+=p2.getPrize2_F();
        }else{
            second_first.setVisibility(View.GONE);
        }
        if(p2.getPrize3_F()!=null && p2.getPrize3_F()!=Long.valueOf(0)) {
            prize3_F.setText(String.valueOf(p2.getPrize3_F()));
            third_first.setVisibility(View.VISIBLE);
            first_T+=p2.getPrize3_F();
        }else{
            third_first.setVisibility(View.GONE);
        }

        if(p2.getPrize1_S()!=null && p2.getPrize1_S()!=Long.valueOf(0)) {
            prize1_S.setText(String.valueOf(p2.getPrize1_S()));
            first_second.setVisibility(View.VISIBLE);
            second_T+=p2.getPrize1_S();
        }else{
            first_second.setVisibility(View.GONE);
        }
        if(p2.getPrize2_S()!=null && p2.getPrize2_S()!=Long.valueOf(0)) {
            prize2_S.setText(String.valueOf(p2.getPrize2_S()));
            second_second.setVisibility(View.VISIBLE);
            second_T+=p2.getPrize2_S();
        }else{
            second_second.setVisibility(View.GONE);
        }
        if(p2.getPrize3_S()!=null && p2.getPrize3_S()!=Long.valueOf(0)) {
            prize3_S.setText(String.valueOf(p2.getPrize3_S()));
            second_T+=p2.getPrize3_S();
            third_second.setVisibility(View.VISIBLE);
        }else{
            third_second.setVisibility(View.GONE);
        }

        if(p2.getPrize1_T()!=null && p2.getPrize1_T()!=Long.valueOf(0)) {
            prize1_Th.setText(String.valueOf(p2.getPrize1_T()));
            first_third.setVisibility(View.VISIBLE);
            third_T+=p2.getPrize1_T();
        }else{
            third_first.setVisibility(View.GONE);
        }
        if(p2.getPrize2_T()!=null && p2.getPrize2_T()!=Long.valueOf(0)) {
            prize2_Th.setText(String.valueOf(p2.getPrize2_T()));
            second_third.setVisibility(View.VISIBLE);
            third_T+=p2.getPrize2_T();
        }else{
            second_third.setVisibility(View.GONE);
        }
        if(p2.getPrize3_T()!=null && p2.getPrize3_T()!=Long.valueOf(0)) {
            prize3_Th.setText(String.valueOf(p2.getPrize3_T()));
            third_third.setVisibility(View.VISIBLE);
            third_T+=p2.getPrize3_T();
        }else{
            third_third.setVisibility(View.GONE);
        }

        prizeT.setText(String.valueOf(p2.getPrizeT()));
    }
    void init1(View view){
        prize_layout = view.findViewById(R.id.prize_layout);
        prize1 = view.findViewById(R.id.prize1);
        prize2 = view.findViewById(R.id.prize2);
        prize3 = view.findViewById(R.id.prize3);
        prize4 = view.findViewById(R.id.prize4);
        prize5 = view.findViewById(R.id.prize5);
        prize6 = view.findViewById(R.id.prize6);
        prize1_F = view.findViewById(R.id.prize1_first);
        first_first = view.findViewById(R.id.first_first);
        text_firstyear = view.findViewById(R.id.text_first_year);

        first = view.findViewById(R.id.prize_first_layout);
        second = view.findViewById(R.id.prize_second_layout);
        third = view.findViewById(R.id.prize_third_layout);
        fourth = view.findViewById(R.id.prize_fourth_layout);
        fifth = view.findViewById(R.id.prize_fifth_layout);
        sixth = view.findViewById(R.id.prize_sixth_layout);
        director_cut_layout = view.findViewById(R.id.director_cut_layout);
        no_ground_zone_layout = view.findViewById(R.id.no_ground_zone_layout);
        prizeT = view.findViewById(R.id.total_prize);
        note_nscet = view.findViewById(R.id.note_nscet);
    }
    void init2(View view){
        prize_layout = view.findViewById(R.id.prize_layout);
        prize1_F = view.findViewById(R.id.prize1_first);
        prize2_F = view.findViewById(R.id.prize2_first);
        prize3_F = view.findViewById(R.id.prize3_first);


        prize1_S = view.findViewById(R.id.prize1_second);
        prize2_S = view.findViewById(R.id.prize2_second);
        prize3_S = view.findViewById(R.id.prize3_second);

        prize1_Th = view.findViewById(R.id.prize1_third);
        prize2_Th = view.findViewById(R.id.prize2_third);
        prize3_Th = view.findViewById(R.id.prize3_third);


        prizeT = view.findViewById(R.id.total_prize);

        text_firstyear = view.findViewById(R.id.text_first_year);
        text_secondyear = view.findViewById(R.id.text_second_year);
        text_thirdyear = view.findViewById(R.id.text_third_year);

        first_first = view.findViewById(R.id.first_first);
        second_second = view.findViewById(R.id.second_second);
        third_third = view.findViewById(R.id.third_third);
        first_second = view.findViewById(R.id.first_second);
        first_third = view.findViewById(R.id.first_third);
        second_first = view.findViewById(R.id.second_first);
        second_third = view.findViewById(R.id.second_third);
        third_first = view.findViewById(R.id.third_first);
        third_second = view.findViewById(R.id.third_second);


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (BtmNavVisCallback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}
