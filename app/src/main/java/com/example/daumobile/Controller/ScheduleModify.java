package com.example.daumobile.Controller;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Schedule;

import io.realm.Realm;
import io.realm.RealmResults;

public class ScheduleModify {
    private static ScheduleModify INSTANCE;
    private Realm mRealm;

    private ScheduleModify(Realm realm) {
        mRealm = realm;
    }

    public static ScheduleModify getInstance(Realm realm) {
        if (INSTANCE == null) {
            INSTANCE = new ScheduleModify(realm);
        }

        return INSTANCE;
    }

    public void insertSchedule(final Schedule schedule) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.insert(schedule);
            }
        });
    }

    public void updateSchedule(final int id_schedule, final Schedule schedule) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Schedule scheduleUpdate = mRealm.where(Schedule.class).equalTo(Constants.KEY_ID_SCHEDULE, id_schedule).findFirst();
                scheduleUpdate.set_class(schedule.get_class());
                scheduleUpdate.setBuoi(schedule.getBuoi());
                scheduleUpdate.setGiang_vien(schedule.getGiang_vien());
                scheduleUpdate.setMa_lop_hp(schedule.getMa_lop_hp());
                scheduleUpdate.setLoai_hoc_phan(schedule.isLoai_hoc_phan());
                scheduleUpdate.setNgay_hoc(schedule.getNgay_hoc());
                scheduleUpdate.setPhong(schedule.getPhong());
                scheduleUpdate.setSo_tiet(schedule.getSo_tiet());
                scheduleUpdate.setThoi_gian(schedule.getThoi_gian());
                scheduleUpdate.setTiet(schedule.getTiet());
            }
        });
    }

    public void deleteSchedule(final int id_schedule) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Schedule scheduleDelete = mRealm.where(Schedule.class).equalTo(Constants.KEY_ID_SCHEDULE, id_schedule).findFirst();
                scheduleDelete.deleteFromRealm();
            }
        });
    }

    public RealmResults<Schedule> queryAllData() {
        return mRealm.where(Schedule.class).findAll();
    }
    public RealmResults<Schedule> queryAllData(int tuan) {
        return mRealm.where(Schedule.class).equalTo(Constants.KEY_TUAN, tuan).findAll();
    }

}
