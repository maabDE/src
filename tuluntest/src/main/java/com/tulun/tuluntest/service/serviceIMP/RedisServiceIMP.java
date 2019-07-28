package com.tulun.tuluntest.service.serviceIMP;

import com.tulun.tuluntest.entity.Subject;
import com.tulun.tuluntest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DSB on 2019/7/26
 */
    @Service
    public class RedisServiceIMP implements RedisService {}
//
//        /*基于redis的模板编程，方便了redis的数据存取操作*/
//        @Autowired
//        private RedisTemplate<String, Map<Integer, Subject>> subjectRedisTemplate;
//
//        @Autowired
//        private StringRedisTemplate strRedisTemplate;
//
//        // 初始化缓存参数
//        public void init() {
//            strRedisTemplate.opsForValue().set("subject_count", "0");
//            strRedisTemplate.opsForValue().set("subject_time", "0");
//            strRedisTemplate.opsForValue().set("subject_id", "-1");
//            //四种状态字符串  => answering：开始答题  answered：答题结束  pushover：未开始答题/推送答题结果   examedone：显示最终闯关结果
//            strRedisTemplate.opsForValue().set("subject_status", "pushover");
//
//            //清除统计数据
//            strRedisTemplate.opsForValue().set("usercnt", "0");
//            strRedisTemplate.opsForValue().set("usercnta", "0");
//            strRedisTemplate.opsForValue().set("usercntb", "0");
//            strRedisTemplate.opsForValue().set("usercntc", "0");
//            strRedisTemplate.opsForValue().set("usercntd", "0");
//
//            setExameRunning(false);
//        }
//
//        public boolean isExameRunning() {
//            return Boolean.parseBoolean(strRedisTemplate.opsForValue().get("isExameRunning"));
//        }
//
//        public void setExameRunning(boolean isExameRunning) {
//            strRedisTemplate.opsForValue().set("isExameRunning", String.valueOf(isExameRunning));
//        }
//
//        public int getUsercnt() {
//
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("usercnt"));
//        }
//
//        public void setUsercnt(int usercnt) {
//            strRedisTemplate.opsForValue().set("usercnt", String.valueOf(usercnt));
//        }
//
//        public int getUsercnta() {
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("usercnta"));
//        }
//
//        public void setUsercnta(int usercnta) {
//            strRedisTemplate.opsForValue().set("usercnta", String.valueOf(usercnta));
//        }
//
//        public int getUsercntb() {
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("usercntb"));
//        }
//
//        public void setUsercntb(int usercntb) {
//            strRedisTemplate.opsForValue().set("usercntb", String.valueOf(usercntb));
//        }
//
//        public int getUsercntc() {
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("usercntc"));
//        }
//
//        public void setUsercntc(int usercntc) {
//            strRedisTemplate.opsForValue().set("usercntc", String.valueOf(usercntc));
//        }
//
//        public int getUsercntd() {
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("usercntd"));
//        }
//
//        public void setUsercntd(int usercntd) {
//            strRedisTemplate.opsForValue().set("usercntd", String.valueOf(usercntd));
//        }
//
//        public void clearPaper() {
//            System.out.println("*********clearPaper*******");
//            Map<Object, Object> subMap = subjectRedisTemplate.boundHashOps("subjectMap").entries();
//
//            if (null != subMap) {
//                subjectRedisTemplate.delete("subjectMap");
//                subjectRedisTemplate.opsForHash().putAll("subjectMap", new HashMap<Integer, Subject>());
//            } else {
//                subjectRedisTemplate.opsForHash().putAll("subjectMap", new HashMap<Integer, Subject>());
//            }
//
//        }
//
//        public boolean isAnswering() {
//            System.out.println("*********setSubjectStatusAnswering*******");
//            String status = strRedisTemplate.opsForValue().get("subject_status");
//            return status.equals("answering");
//        }
//
//        public boolean isAnswered() {
//            System.out.println("*********setSubjectStatusAnswering*******");
//            String status = strRedisTemplate.opsForValue().get("subject_status");
//            return status.equals("answered");
//        }
//
//        public boolean isPushOver() {
//            System.out.println("*********setSubjectStatusAnswering*******");
//            String status = strRedisTemplate.opsForValue().get("subject_status");
//            return status.equals("pushover");
//        }
//
//        public boolean isExameDone() {
//            String status = strRedisTemplate.opsForValue().get("subject_status");
//            return status.equals("examedone");
//        }
//
//        public void setSubjectStatusAnswering() {
//            System.out.println("*********setSubjectStatusAnswering*******");
//            strRedisTemplate.opsForValue().set("subject_status", "answering");
//        }
//
//        public void setSubjectStatusAnswered() {
//            System.out.println("*********setSubjectStatusAnswered*******");
//            strRedisTemplate.opsForValue().set("subject_status", "answered");
//        }
//
//        public void setSubjectStatusPushOver() {
//            System.out.println("*********setSubjectStatusPushOver*******");
//            strRedisTemplate.opsForValue().set("subject_status", "pushover");
//        }
//
//        public void setSubjectStatusExameDone() {
//            System.out.println("*********setSubjectStatusExameDone*******");
//            strRedisTemplate.opsForValue().set("subject_status", "examedone");
//        }
//
//        public String getSubjectStatus() {
//            System.out.println("*********getSubjectStatus*******");
//            return strRedisTemplate.opsForValue().get("subject_status");
//        }
//
//        public int getSubjectCount() {
//            System.out.println("*********getSubjectCount*******");
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("subject_count"));
//        }
//
//        public void setSubjectCount(int count) {
//            System.out.println("*********setSubjectCount*******");
//            strRedisTemplate.opsForValue().set("subject_count", String.valueOf(count));
//        }
//
//        public int getSubjectTime() {
//            System.out.println("*********getSubjectTime*******");
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("subject_time"));
//        }
//
//        public void setSubjectTime(int time) {
//            System.out.println("*********setSubjectTime*******");
//            strRedisTemplate.opsForValue().set("subject_time", String.valueOf(time));
//        }
//
//        public int getSubjectId() {
//            System.out.println("*********getSubjectId*******");
//            return Integer.parseInt(strRedisTemplate.opsForValue().get("subject_id"));
//        }
//
//        public void setSubjectId(int id) {
//            System.out.println("*********setSubjectId*******");
//            strRedisTemplate.opsForValue().set("subject_id", String.valueOf(id));
//        }
//
//        public void clearCache() {
//            //清除缓存数据和标志位
//            init();
//
//            //清除选择的题目
//            clearPaper();
//        }
//
//        public int getListSize() {
//            System.out.println("*********getListSize*******");
//            return subjectRedisTemplate.boundHashOps("subjectMap").size().intValue();
//        }
//
//        public void addSubjects(Subject sub) {
//            System.out.println("*********addSubjects*******");
//            subjectRedisTemplate.opsForHash().put("subjectMap", String.valueOf(sub.getId()), sub);
//            System.out.println("*********put Subjects success*******");
//        }
//
//        public Collection<Subject> getSubjectList() {
//            System.out.println("*********getSubjectList*******");
//            HashOperations<String, Integer, Subject> hashOps = subjectRedisTemplate.opsForHash();
//            System.out.println(hashOps.values("subjectMap").size());
//            hashOps.keys("subjectMap");
//            return hashOps.values("subjectMap");
//        }
//
//        public Subject getSubject(int subid) {
//            System.out.println("*********getSubject*******");
//            HashOperations<String, Integer, Subject> hashOps = subjectRedisTemplate.opsForHash();
//
//            return hashOps.get("subjectMap", String.valueOf(subid));
//        }
//    }
//}
