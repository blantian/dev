package org.xtj.grpc;

import akka.remote.WireFormats;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.apache.flink.util.TimeUtils;
import org.xtj.common.Constant;
import usercourse.UserCourse;
import usercourse.usrcouseGrpc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Skywalker
 * @date 2021/7/20 上午11:53
 */
public class GRPCClient {
    private static final Logger logger = Logger.getLogger(GRPCClient.class.getName());

    private static final String host = Constant.grpc_ip;
    private static final int serverPort = Constant.grpc_port;

    private static ManagedChannel managedChannel = null;
    private static usrcouseGrpc.usrcouseFutureStub usrFutureStub;

    public GRPCClient() {
        GRPCClient.managedChannel = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        GRPCClient.usrFutureStub = usrcouseGrpc.newFutureStub(managedChannel);
    }


    public ListenableFuture<UserCourse.GetCourseInfoResponse> getCourseIds(List<Integer> lessonIdList) throws ExecutionException, InterruptedException {
        ArrayList<UserCourse.GetCourseInfoRequest.Detailed> detailedList = new ArrayList();
        for (int i = 0; i <lessonIdList.size() ; i++) {
            UserCourse.GetCourseInfoRequest.Detailed detailed =UserCourse.GetCourseInfoRequest.Detailed.newBuilder().setLessonId(lessonIdList.get(i)).build();
            detailedList.add(detailed);
        }
        try {
            UserCourse.GetCourseInfoRequest request =  UserCourse.GetCourseInfoRequest.newBuilder().addAllDetailed(detailedList).build();
            ListenableFuture<UserCourse.GetCourseInfoResponse> response;
            response = usrFutureStub.getCourseInfo(request);
            return response;
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {}", e.getStatus());
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            managedChannel.awaitTermination(5, TimeUnit.SECONDS);
//            managedChannel.shutdown();
        }
    }

}
