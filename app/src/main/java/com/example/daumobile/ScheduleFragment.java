package com.example.daumobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.Adapter.ScheduleAdapter;
import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Controller.ScheduleModify;
import com.example.daumobile.Files.FileService;
import com.example.daumobile.Model.Schedule;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {
    private RecyclerView mRecyclerviewSchedule;
    private Realm mRealm;
    private RealmResults<Schedule> mRealmResult;
    private ScheduleAdapter mScheduleAdapter;
    private ScheduleModify instanceSchedule;
    private Button btn_schedule_semester;
    private Button btn_schedule_week;
    private TextView tv_schedule_semester_value;
    private TextView tv_schedule_week_value;
    private FileService fileService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialization();
        config();
    }

    private void config() {
        configRealm();
        configRecyclerview();
    }

    private void configRecyclerview() {
        mScheduleAdapter = new ScheduleAdapter(getContext(), mRealmResult, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        mRecyclerviewSchedule.setAdapter(mScheduleAdapter);
        mRecyclerviewSchedule.setLayoutManager(linearLayoutManager);
        mRecyclerviewSchedule.setHasFixedSize(true);
        mRecyclerviewSchedule.addItemDecoration(dividerItemDecoration);
    }

    private void configRealm() {
        Realm.init(getActivity());
        RealmConfiguration configPoint = new RealmConfiguration.Builder().name(Constants.KEY_TABLE_NAME_SCHEDULE)
                .schemaVersion(1)
                .build();

        mRealm = Realm.getInstance(configPoint);
        instanceSchedule = ScheduleModify.getInstance(mRealm);
        mRealmResult = instanceSchedule.queryAllData();
        if (mRealmResult.size() == 0) {
            addData();
        }
    }

    private void addData() {
        ArrayList<Schedule> schedules = FileService.readSchedule(Constants.PATH_FILE_SCHEDULE);
        for (Schedule schedule : schedules) {
            Log.d("LOG_ADD_SCHEDULE", "addData: " + schedule.toString());
            instanceSchedule.insertSchedule(schedule);
        }
    }

    private void initialization() {
        mapp();
        fileService = new FileService();
    }

    private void mapp() {
        mRecyclerviewSchedule = getActivity().findViewById(R.id.recyclerview_schedule);
        btn_schedule_semester = getActivity().findViewById(R.id.btn_schedule_semester);
        btn_schedule_week = getActivity().findViewById(R.id.btn_schedule_week);
        tv_schedule_semester_value = getActivity().findViewById(R.id.tv_schedule_semester_value);
        tv_schedule_week_value = getActivity().findViewById(R.id.tv_schedule_week_value);
    }
}
