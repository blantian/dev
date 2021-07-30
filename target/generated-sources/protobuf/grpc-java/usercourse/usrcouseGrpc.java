package usercourse;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: user_course.proto")
public final class usrcouseGrpc {

  private usrcouseGrpc() {}

  public static final String SERVICE_NAME = "usercourse.usrcouse";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<usercourse.UserCourse.GetUserAreaRequest,
      usercourse.UserCourse.GetUserAreaResponse> METHOD_GET_USER_AREA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "usercourse.usrcouse", "GetUserArea"),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.GetUserAreaRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.GetUserAreaResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<usercourse.UserCourse.GetCourseInfoRequest,
      usercourse.UserCourse.GetCourseInfoResponse> METHOD_GET_COURSE_INFO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "usercourse.usrcouse", "GetCourseInfo"),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.GetCourseInfoRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.GetCourseInfoResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<usercourse.UserCourse.WxAccountsUserRequest,
      usercourse.UserCourse.WxAccountsUserResponse> METHOD_WX_ACCOUNTS_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "usercourse.usrcouse", "WxAccountsUser"),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.WxAccountsUserRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.WxAccountsUserResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<usercourse.UserCourse.WxContactsRequest,
      usercourse.UserCourse.WxContactsResponse> METHOD_WX_CONTACTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "usercourse.usrcouse", "WxContacts"),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.WxContactsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(usercourse.UserCourse.WxContactsResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static usrcouseStub newStub(io.grpc.Channel channel) {
    return new usrcouseStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static usrcouseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new usrcouseBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static usrcouseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new usrcouseFutureStub(channel);
  }

  /**
   */
  public static abstract class usrcouseImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserArea(usercourse.UserCourse.GetUserAreaRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.GetUserAreaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_AREA, responseObserver);
    }

    /**
     */
    public void getCourseInfo(usercourse.UserCourse.GetCourseInfoRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.GetCourseInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_COURSE_INFO, responseObserver);
    }

    /**
     */
    public void wxAccountsUser(usercourse.UserCourse.WxAccountsUserRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.WxAccountsUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WX_ACCOUNTS_USER, responseObserver);
    }

    /**
     */
    public void wxContacts(usercourse.UserCourse.WxContactsRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.WxContactsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WX_CONTACTS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER_AREA,
            asyncUnaryCall(
              new MethodHandlers<
                usercourse.UserCourse.GetUserAreaRequest,
                usercourse.UserCourse.GetUserAreaResponse>(
                  this, METHODID_GET_USER_AREA)))
          .addMethod(
            METHOD_GET_COURSE_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                usercourse.UserCourse.GetCourseInfoRequest,
                usercourse.UserCourse.GetCourseInfoResponse>(
                  this, METHODID_GET_COURSE_INFO)))
          .addMethod(
            METHOD_WX_ACCOUNTS_USER,
            asyncUnaryCall(
              new MethodHandlers<
                usercourse.UserCourse.WxAccountsUserRequest,
                usercourse.UserCourse.WxAccountsUserResponse>(
                  this, METHODID_WX_ACCOUNTS_USER)))
          .addMethod(
            METHOD_WX_CONTACTS,
            asyncUnaryCall(
              new MethodHandlers<
                usercourse.UserCourse.WxContactsRequest,
                usercourse.UserCourse.WxContactsResponse>(
                  this, METHODID_WX_CONTACTS)))
          .build();
    }
  }

  /**
   */
  public static final class usrcouseStub extends io.grpc.stub.AbstractStub<usrcouseStub> {
    private usrcouseStub(io.grpc.Channel channel) {
      super(channel);
    }

    private usrcouseStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected usrcouseStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new usrcouseStub(channel, callOptions);
    }

    /**
     */
    public void getUserArea(usercourse.UserCourse.GetUserAreaRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.GetUserAreaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_AREA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseInfo(usercourse.UserCourse.GetCourseInfoRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.GetCourseInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_COURSE_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void wxAccountsUser(usercourse.UserCourse.WxAccountsUserRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.WxAccountsUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WX_ACCOUNTS_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void wxContacts(usercourse.UserCourse.WxContactsRequest request,
        io.grpc.stub.StreamObserver<usercourse.UserCourse.WxContactsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WX_CONTACTS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class usrcouseBlockingStub extends io.grpc.stub.AbstractStub<usrcouseBlockingStub> {
    private usrcouseBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private usrcouseBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected usrcouseBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new usrcouseBlockingStub(channel, callOptions);
    }

    /**
     */
    public usercourse.UserCourse.GetUserAreaResponse getUserArea(usercourse.UserCourse.GetUserAreaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_AREA, getCallOptions(), request);
    }

    /**
     */
    public usercourse.UserCourse.GetCourseInfoResponse getCourseInfo(usercourse.UserCourse.GetCourseInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_COURSE_INFO, getCallOptions(), request);
    }

    /**
     */
    public usercourse.UserCourse.WxAccountsUserResponse wxAccountsUser(usercourse.UserCourse.WxAccountsUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WX_ACCOUNTS_USER, getCallOptions(), request);
    }

    /**
     */
    public usercourse.UserCourse.WxContactsResponse wxContacts(usercourse.UserCourse.WxContactsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WX_CONTACTS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class usrcouseFutureStub extends io.grpc.stub.AbstractStub<usrcouseFutureStub> {
    private usrcouseFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private usrcouseFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected usrcouseFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new usrcouseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<usercourse.UserCourse.GetUserAreaResponse> getUserArea(
        usercourse.UserCourse.GetUserAreaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_AREA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<usercourse.UserCourse.GetCourseInfoResponse> getCourseInfo(
        usercourse.UserCourse.GetCourseInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_COURSE_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<usercourse.UserCourse.WxAccountsUserResponse> wxAccountsUser(
        usercourse.UserCourse.WxAccountsUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WX_ACCOUNTS_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<usercourse.UserCourse.WxContactsResponse> wxContacts(
        usercourse.UserCourse.WxContactsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WX_CONTACTS, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_AREA = 0;
  private static final int METHODID_GET_COURSE_INFO = 1;
  private static final int METHODID_WX_ACCOUNTS_USER = 2;
  private static final int METHODID_WX_CONTACTS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final usrcouseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(usrcouseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_AREA:
          serviceImpl.getUserArea((usercourse.UserCourse.GetUserAreaRequest) request,
              (io.grpc.stub.StreamObserver<usercourse.UserCourse.GetUserAreaResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_INFO:
          serviceImpl.getCourseInfo((usercourse.UserCourse.GetCourseInfoRequest) request,
              (io.grpc.stub.StreamObserver<usercourse.UserCourse.GetCourseInfoResponse>) responseObserver);
          break;
        case METHODID_WX_ACCOUNTS_USER:
          serviceImpl.wxAccountsUser((usercourse.UserCourse.WxAccountsUserRequest) request,
              (io.grpc.stub.StreamObserver<usercourse.UserCourse.WxAccountsUserResponse>) responseObserver);
          break;
        case METHODID_WX_CONTACTS:
          serviceImpl.wxContacts((usercourse.UserCourse.WxContactsRequest) request,
              (io.grpc.stub.StreamObserver<usercourse.UserCourse.WxContactsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class usrcouseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return usercourse.UserCourse.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (usrcouseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new usrcouseDescriptorSupplier())
              .addMethod(METHOD_GET_USER_AREA)
              .addMethod(METHOD_GET_COURSE_INFO)
              .addMethod(METHOD_WX_ACCOUNTS_USER)
              .addMethod(METHOD_WX_CONTACTS)
              .build();
        }
      }
    }
    return result;
  }
}
