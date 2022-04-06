//package com.rapdog.rapbot.bean.vo;
//
//
//import com.rapdog.rapbot.listener.group.GroupAddOneRepeater;
//import love.forte.simbot.LoggerFactory;
//import org.slf4j.Logger;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author renzx
// */
//public class AddOneCounter {
//
//    private static final Logger logger = LoggerFactory.getLogger(AddOneCounter.class);
//
//    private static Map<Long, MessageCounter> addOneCountMap = new HashMap<>(64);
//
//    public static boolean isAddOne(Long groupId,String message){
//        if (addOneCountMap.get(groupId) != null){
//            MessageCounter mc = addOneCountMap.get(groupId);
//            if (message.equals(mc.getMessage())){
//                if (mc.getCount() > 0){
//                    return true;
//                }else{
//                    mc.setCount(mc.getCount()+1);
//                    addOneCountMap.put(groupId,mc);
//                    return false;
//                }
//            }else{
//                mc.setMessage(message);
//                mc.setCount(1);
//                addOneCountMap.put(groupId,mc);
//                return false;
//            }
//        }else {
//            logger.info("+_+_+_+_+_+_+__+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+");
//            MessageCounter mc = new MessageCounter();
//            mc.setMessage(message);
//            mc.setCount(1);
//            addOneCountMap.put(groupId,mc);
//            return false;
//        }
//    }
//
//
//    public static class MessageCounter{
//        private String message;
//
//        private Integer count;
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public Integer getCount() {
//            return count;
//        }
//
//        public void setCount(Integer count) {
//            this.count = count;
//        }
//
//    }
//}
