// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Complex.proto

package ru.itmo.java.message.complex;

public final class Complex {
  private Complex() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_complex_EchoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_complex_EchoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_complex_EchoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_complex_EchoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_complex_CalculationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_complex_CalculationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_complex_CalculationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_complex_CalculationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_complex_BaseRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_complex_BaseRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_complex_BaseResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_complex_BaseResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rComplex.proto\022\034ru.itmo.java.message.co" +
      "mplex\"\036\n\013EchoRequest\022\017\n\007message\030\001 \001(\t\"\037\n" +
      "\014EchoResponse\022\017\n\007message\030\001 \001(\t\"\252\001\n\022Calcu" +
      "lationRequest\022\t\n\001x\030\001 \001(\005\022\t\n\001y\030\002 \001(\005\022M\n\to" +
      "peration\030\003 \001(\0162:.ru.itmo.java.message.co" +
      "mplex.CalculationRequest.Operation\"/\n\tOp" +
      "eration\022\007\n\003Add\020\000\022\007\n\003Sub\020\001\022\007\n\003Mul\020\002\022\007\n\003Di" +
      "v\020\003\"%\n\023CalculationResponse\022\016\n\006result\030\001 \001" +
      "(\005\"\252\001\n\013BaseRequest\022@\n\013echoRequest\030\001 \001(\0132" +
      ").ru.itmo.java.message.complex.EchoReque" +
      "stH\000\022N\n\022calculationRequest\030\002 \001(\01320.ru.it" +
      "mo.java.message.complex.CalculationReque" +
      "stH\000B\t\n\007request\"\260\001\n\014BaseResponse\022B\n\014echo" +
      "Response\030\001 \001(\0132*.ru.itmo.java.message.co" +
      "mplex.EchoResponseH\000\022P\n\023calculationRespo" +
      "nse\030\002 \001(\01321.ru.itmo.java.message.complex" +
      ".CalculationResponseH\000B\n\n\010responseB\002P\001b\006" +
      "proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ru_itmo_java_message_complex_EchoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ru_itmo_java_message_complex_EchoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_complex_EchoRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_ru_itmo_java_message_complex_EchoResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ru_itmo_java_message_complex_EchoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_complex_EchoResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_ru_itmo_java_message_complex_CalculationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ru_itmo_java_message_complex_CalculationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_complex_CalculationRequest_descriptor,
        new java.lang.String[] { "X", "Y", "Operation", });
    internal_static_ru_itmo_java_message_complex_CalculationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ru_itmo_java_message_complex_CalculationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_complex_CalculationResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_ru_itmo_java_message_complex_BaseRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ru_itmo_java_message_complex_BaseRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_complex_BaseRequest_descriptor,
        new java.lang.String[] { "EchoRequest", "CalculationRequest", "Request", });
    internal_static_ru_itmo_java_message_complex_BaseResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ru_itmo_java_message_complex_BaseResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_complex_BaseResponse_descriptor,
        new java.lang.String[] { "EchoResponse", "CalculationResponse", "Response", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}