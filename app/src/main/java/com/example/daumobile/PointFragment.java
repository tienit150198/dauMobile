package com.example.daumobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.Adapter.PointAdapter;
import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Controller.PointModify;
import com.example.daumobile.Files.FileService;
import com.example.daumobile.Model.Point;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PointFragment extends Fragment {
    private RecyclerView mRecyclerviewPoint;
    private Realm mRealm;
    private RealmResults<Point> mRealmResult;
    private PointAdapter mPointAdapter;
    private TextView tv_point_dtb;
    private TextView tv_point_stc_fail;
    private TextView tv_point_hocluc;
    private TextView tv_point_name_semester;
    private ImageView img_point_sub_semester;
    private ImageView img_point_plus_semester;
    private PointModify instancePoint;
    private FileService fileService;

    private int currentSemester = 1;

    public PointFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_point, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialization();
        config();
        setClick();
    }

    private void setClick() {
        img_point_sub_semester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSemester > 1){
                    changeSemester(false);
                }
            }
        });

        img_point_plus_semester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long _maxSemester = instancePoint.queryHocKyMax();
                if(currentSemester < _maxSemester){
                    changeSemester(true);
                }
            }
        });
    }

    private void changeSemester(boolean isPlus) {
        if(isPlus){
            currentSemester++;
        }else{
            currentSemester--;
        }

        tv_point_name_semester.setText("Học kỳ " + currentSemester);
        mRealmResult = (instancePoint.queryAllData(currentSemester));
        mPointAdapter = new PointAdapter(getContext(), mRealmResult, true);
        mRecyclerviewPoint.setAdapter(mPointAdapter);
    }

    private void config() {
        configRealm();
        configRecyclerview();
    }

    private void configRecyclerview() {
        mPointAdapter = new PointAdapter(getContext(), mRealmResult, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);

        mRecyclerviewPoint.setAdapter(mPointAdapter);
        mRecyclerviewPoint.setLayoutManager(linearLayoutManager);
        mRecyclerviewPoint.setHasFixedSize(true);
        mRecyclerviewPoint.addItemDecoration(dividerItemDecoration);
    }

    private void configRealm() {
        Realm.init(getActivity());
        RealmConfiguration configPoint = new RealmConfiguration.Builder().name(Constants.KEY_TABLE_NAME_POINT)
                .schemaVersion(1)
                .build();

        mRealm = Realm.getInstance(configPoint);
        instancePoint = PointModify.getInstance(mRealm);
        mRealmResult = instancePoint.queryAllData(currentSemester);

        if (mRealmResult.size() == 0) {
            addData();
        }
    }

    private void addData() {
        ArrayList<Point> points = FileService.readPoint(Constants.PATH_FILE_POINT);
        for (Point point : points) {
            instancePoint.insertPoint(point);
        }
        mRealmResult = instancePoint.queryAllData(currentSemester);
    }

    private void initialization() {
        mapp();
        fileService = new FileService();
    }

    private void mapp() {
        mRecyclerviewPoint = getActivity().findViewById(R.id.recyclerview_point);
        tv_point_name_semester = getActivity().findViewById(R.id.tv_point_name_semester);
        tv_point_stc_fail = getActivity().findViewById(R.id.tv_point_stc_fail);
        tv_point_hocluc = getActivity().findViewById(R.id.tv_point_hocluc);
        tv_point_name_semester = getActivity().findViewById(R.id.tv_point_name_semester);
        img_point_sub_semester = getActivity().findViewById(R.id.img_point_sub_semester);
        img_point_plus_semester = getActivity().findViewById(R.id.img_point_plus_semester);
    }
}
