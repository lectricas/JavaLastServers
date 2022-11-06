// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Complex.proto

package ru.itmo.java.message.complex;

/**
 * Protobuf type {@code ru.itmo.java.message.complex.BaseResponse}
 */
public final class BaseResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.complex.BaseResponse)
    BaseResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BaseResponse.newBuilder() to construct.
  private BaseResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BaseResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BaseResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BaseResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            ru.itmo.java.message.complex.EchoResponse.Builder subBuilder = null;
            if (responseCase_ == 1) {
              subBuilder = ((ru.itmo.java.message.complex.EchoResponse) response_).toBuilder();
            }
            response_ =
                input.readMessage(ru.itmo.java.message.complex.EchoResponse.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((ru.itmo.java.message.complex.EchoResponse) response_);
              response_ = subBuilder.buildPartial();
            }
            responseCase_ = 1;
            break;
          }
          case 18: {
            ru.itmo.java.message.complex.CalculationResponse.Builder subBuilder = null;
            if (responseCase_ == 2) {
              subBuilder = ((ru.itmo.java.message.complex.CalculationResponse) response_).toBuilder();
            }
            response_ =
                input.readMessage(ru.itmo.java.message.complex.CalculationResponse.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((ru.itmo.java.message.complex.CalculationResponse) response_);
              response_ = subBuilder.buildPartial();
            }
            responseCase_ = 2;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_BaseResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_BaseResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.complex.BaseResponse.class, ru.itmo.java.message.complex.BaseResponse.Builder.class);
  }

  private int responseCase_ = 0;
  private java.lang.Object response_;
  public enum ResponseCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    ECHORESPONSE(1),
    CALCULATIONRESPONSE(2),
    RESPONSE_NOT_SET(0);
    private final int value;
    private ResponseCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ResponseCase valueOf(int value) {
      return forNumber(value);
    }

    public static ResponseCase forNumber(int value) {
      switch (value) {
        case 1: return ECHORESPONSE;
        case 2: return CALCULATIONRESPONSE;
        case 0: return RESPONSE_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public ResponseCase
  getResponseCase() {
    return ResponseCase.forNumber(
        responseCase_);
  }

  public static final int ECHORESPONSE_FIELD_NUMBER = 1;
  /**
   * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
   * @return Whether the echoResponse field is set.
   */
  @java.lang.Override
  public boolean hasEchoResponse() {
    return responseCase_ == 1;
  }
  /**
   * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
   * @return The echoResponse.
   */
  @java.lang.Override
  public ru.itmo.java.message.complex.EchoResponse getEchoResponse() {
    if (responseCase_ == 1) {
       return (ru.itmo.java.message.complex.EchoResponse) response_;
    }
    return ru.itmo.java.message.complex.EchoResponse.getDefaultInstance();
  }
  /**
   * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.complex.EchoResponseOrBuilder getEchoResponseOrBuilder() {
    if (responseCase_ == 1) {
       return (ru.itmo.java.message.complex.EchoResponse) response_;
    }
    return ru.itmo.java.message.complex.EchoResponse.getDefaultInstance();
  }

  public static final int CALCULATIONRESPONSE_FIELD_NUMBER = 2;
  /**
   * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
   * @return Whether the calculationResponse field is set.
   */
  @java.lang.Override
  public boolean hasCalculationResponse() {
    return responseCase_ == 2;
  }
  /**
   * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
   * @return The calculationResponse.
   */
  @java.lang.Override
  public ru.itmo.java.message.complex.CalculationResponse getCalculationResponse() {
    if (responseCase_ == 2) {
       return (ru.itmo.java.message.complex.CalculationResponse) response_;
    }
    return ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance();
  }
  /**
   * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.complex.CalculationResponseOrBuilder getCalculationResponseOrBuilder() {
    if (responseCase_ == 2) {
       return (ru.itmo.java.message.complex.CalculationResponse) response_;
    }
    return ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (responseCase_ == 1) {
      output.writeMessage(1, (ru.itmo.java.message.complex.EchoResponse) response_);
    }
    if (responseCase_ == 2) {
      output.writeMessage(2, (ru.itmo.java.message.complex.CalculationResponse) response_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (responseCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (ru.itmo.java.message.complex.EchoResponse) response_);
    }
    if (responseCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (ru.itmo.java.message.complex.CalculationResponse) response_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.itmo.java.message.complex.BaseResponse)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.complex.BaseResponse other = (ru.itmo.java.message.complex.BaseResponse) obj;

    if (!getResponseCase().equals(other.getResponseCase())) return false;
    switch (responseCase_) {
      case 1:
        if (!getEchoResponse()
            .equals(other.getEchoResponse())) return false;
        break;
      case 2:
        if (!getCalculationResponse()
            .equals(other.getCalculationResponse())) return false;
        break;
      case 0:
      default:
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    switch (responseCase_) {
      case 1:
        hash = (37 * hash) + ECHORESPONSE_FIELD_NUMBER;
        hash = (53 * hash) + getEchoResponse().hashCode();
        break;
      case 2:
        hash = (37 * hash) + CALCULATIONRESPONSE_FIELD_NUMBER;
        hash = (53 * hash) + getCalculationResponse().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.complex.BaseResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.itmo.java.message.complex.BaseResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ru.itmo.java.message.complex.BaseResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.complex.BaseResponse)
      ru.itmo.java.message.complex.BaseResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_BaseResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_BaseResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.complex.BaseResponse.class, ru.itmo.java.message.complex.BaseResponse.Builder.class);
    }

    // Construct using ru.itmo.java.message.complex.BaseResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      responseCase_ = 0;
      response_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_BaseResponse_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.complex.BaseResponse getDefaultInstanceForType() {
      return ru.itmo.java.message.complex.BaseResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.complex.BaseResponse build() {
      ru.itmo.java.message.complex.BaseResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.complex.BaseResponse buildPartial() {
      ru.itmo.java.message.complex.BaseResponse result = new ru.itmo.java.message.complex.BaseResponse(this);
      if (responseCase_ == 1) {
        if (echoResponseBuilder_ == null) {
          result.response_ = response_;
        } else {
          result.response_ = echoResponseBuilder_.build();
        }
      }
      if (responseCase_ == 2) {
        if (calculationResponseBuilder_ == null) {
          result.response_ = response_;
        } else {
          result.response_ = calculationResponseBuilder_.build();
        }
      }
      result.responseCase_ = responseCase_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.itmo.java.message.complex.BaseResponse) {
        return mergeFrom((ru.itmo.java.message.complex.BaseResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.complex.BaseResponse other) {
      if (other == ru.itmo.java.message.complex.BaseResponse.getDefaultInstance()) return this;
      switch (other.getResponseCase()) {
        case ECHORESPONSE: {
          mergeEchoResponse(other.getEchoResponse());
          break;
        }
        case CALCULATIONRESPONSE: {
          mergeCalculationResponse(other.getCalculationResponse());
          break;
        }
        case RESPONSE_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.itmo.java.message.complex.BaseResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.complex.BaseResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int responseCase_ = 0;
    private java.lang.Object response_;
    public ResponseCase
        getResponseCase() {
      return ResponseCase.forNumber(
          responseCase_);
    }

    public Builder clearResponse() {
      responseCase_ = 0;
      response_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.complex.EchoResponse, ru.itmo.java.message.complex.EchoResponse.Builder, ru.itmo.java.message.complex.EchoResponseOrBuilder> echoResponseBuilder_;
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     * @return Whether the echoResponse field is set.
     */
    @java.lang.Override
    public boolean hasEchoResponse() {
      return responseCase_ == 1;
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     * @return The echoResponse.
     */
    @java.lang.Override
    public ru.itmo.java.message.complex.EchoResponse getEchoResponse() {
      if (echoResponseBuilder_ == null) {
        if (responseCase_ == 1) {
          return (ru.itmo.java.message.complex.EchoResponse) response_;
        }
        return ru.itmo.java.message.complex.EchoResponse.getDefaultInstance();
      } else {
        if (responseCase_ == 1) {
          return echoResponseBuilder_.getMessage();
        }
        return ru.itmo.java.message.complex.EchoResponse.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    public Builder setEchoResponse(ru.itmo.java.message.complex.EchoResponse value) {
      if (echoResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        response_ = value;
        onChanged();
      } else {
        echoResponseBuilder_.setMessage(value);
      }
      responseCase_ = 1;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    public Builder setEchoResponse(
        ru.itmo.java.message.complex.EchoResponse.Builder builderForValue) {
      if (echoResponseBuilder_ == null) {
        response_ = builderForValue.build();
        onChanged();
      } else {
        echoResponseBuilder_.setMessage(builderForValue.build());
      }
      responseCase_ = 1;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    public Builder mergeEchoResponse(ru.itmo.java.message.complex.EchoResponse value) {
      if (echoResponseBuilder_ == null) {
        if (responseCase_ == 1 &&
            response_ != ru.itmo.java.message.complex.EchoResponse.getDefaultInstance()) {
          response_ = ru.itmo.java.message.complex.EchoResponse.newBuilder((ru.itmo.java.message.complex.EchoResponse) response_)
              .mergeFrom(value).buildPartial();
        } else {
          response_ = value;
        }
        onChanged();
      } else {
        if (responseCase_ == 1) {
          echoResponseBuilder_.mergeFrom(value);
        }
        echoResponseBuilder_.setMessage(value);
      }
      responseCase_ = 1;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    public Builder clearEchoResponse() {
      if (echoResponseBuilder_ == null) {
        if (responseCase_ == 1) {
          responseCase_ = 0;
          response_ = null;
          onChanged();
        }
      } else {
        if (responseCase_ == 1) {
          responseCase_ = 0;
          response_ = null;
        }
        echoResponseBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    public ru.itmo.java.message.complex.EchoResponse.Builder getEchoResponseBuilder() {
      return getEchoResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    @java.lang.Override
    public ru.itmo.java.message.complex.EchoResponseOrBuilder getEchoResponseOrBuilder() {
      if ((responseCase_ == 1) && (echoResponseBuilder_ != null)) {
        return echoResponseBuilder_.getMessageOrBuilder();
      } else {
        if (responseCase_ == 1) {
          return (ru.itmo.java.message.complex.EchoResponse) response_;
        }
        return ru.itmo.java.message.complex.EchoResponse.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.complex.EchoResponse echoResponse = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.complex.EchoResponse, ru.itmo.java.message.complex.EchoResponse.Builder, ru.itmo.java.message.complex.EchoResponseOrBuilder> 
        getEchoResponseFieldBuilder() {
      if (echoResponseBuilder_ == null) {
        if (!(responseCase_ == 1)) {
          response_ = ru.itmo.java.message.complex.EchoResponse.getDefaultInstance();
        }
        echoResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.itmo.java.message.complex.EchoResponse, ru.itmo.java.message.complex.EchoResponse.Builder, ru.itmo.java.message.complex.EchoResponseOrBuilder>(
                (ru.itmo.java.message.complex.EchoResponse) response_,
                getParentForChildren(),
                isClean());
        response_ = null;
      }
      responseCase_ = 1;
      onChanged();;
      return echoResponseBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.complex.CalculationResponse, ru.itmo.java.message.complex.CalculationResponse.Builder, ru.itmo.java.message.complex.CalculationResponseOrBuilder> calculationResponseBuilder_;
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     * @return Whether the calculationResponse field is set.
     */
    @java.lang.Override
    public boolean hasCalculationResponse() {
      return responseCase_ == 2;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     * @return The calculationResponse.
     */
    @java.lang.Override
    public ru.itmo.java.message.complex.CalculationResponse getCalculationResponse() {
      if (calculationResponseBuilder_ == null) {
        if (responseCase_ == 2) {
          return (ru.itmo.java.message.complex.CalculationResponse) response_;
        }
        return ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance();
      } else {
        if (responseCase_ == 2) {
          return calculationResponseBuilder_.getMessage();
        }
        return ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    public Builder setCalculationResponse(ru.itmo.java.message.complex.CalculationResponse value) {
      if (calculationResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        response_ = value;
        onChanged();
      } else {
        calculationResponseBuilder_.setMessage(value);
      }
      responseCase_ = 2;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    public Builder setCalculationResponse(
        ru.itmo.java.message.complex.CalculationResponse.Builder builderForValue) {
      if (calculationResponseBuilder_ == null) {
        response_ = builderForValue.build();
        onChanged();
      } else {
        calculationResponseBuilder_.setMessage(builderForValue.build());
      }
      responseCase_ = 2;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    public Builder mergeCalculationResponse(ru.itmo.java.message.complex.CalculationResponse value) {
      if (calculationResponseBuilder_ == null) {
        if (responseCase_ == 2 &&
            response_ != ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance()) {
          response_ = ru.itmo.java.message.complex.CalculationResponse.newBuilder((ru.itmo.java.message.complex.CalculationResponse) response_)
              .mergeFrom(value).buildPartial();
        } else {
          response_ = value;
        }
        onChanged();
      } else {
        if (responseCase_ == 2) {
          calculationResponseBuilder_.mergeFrom(value);
        }
        calculationResponseBuilder_.setMessage(value);
      }
      responseCase_ = 2;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    public Builder clearCalculationResponse() {
      if (calculationResponseBuilder_ == null) {
        if (responseCase_ == 2) {
          responseCase_ = 0;
          response_ = null;
          onChanged();
        }
      } else {
        if (responseCase_ == 2) {
          responseCase_ = 0;
          response_ = null;
        }
        calculationResponseBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    public ru.itmo.java.message.complex.CalculationResponse.Builder getCalculationResponseBuilder() {
      return getCalculationResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    @java.lang.Override
    public ru.itmo.java.message.complex.CalculationResponseOrBuilder getCalculationResponseOrBuilder() {
      if ((responseCase_ == 2) && (calculationResponseBuilder_ != null)) {
        return calculationResponseBuilder_.getMessageOrBuilder();
      } else {
        if (responseCase_ == 2) {
          return (ru.itmo.java.message.complex.CalculationResponse) response_;
        }
        return ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationResponse calculationResponse = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.complex.CalculationResponse, ru.itmo.java.message.complex.CalculationResponse.Builder, ru.itmo.java.message.complex.CalculationResponseOrBuilder> 
        getCalculationResponseFieldBuilder() {
      if (calculationResponseBuilder_ == null) {
        if (!(responseCase_ == 2)) {
          response_ = ru.itmo.java.message.complex.CalculationResponse.getDefaultInstance();
        }
        calculationResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.itmo.java.message.complex.CalculationResponse, ru.itmo.java.message.complex.CalculationResponse.Builder, ru.itmo.java.message.complex.CalculationResponseOrBuilder>(
                (ru.itmo.java.message.complex.CalculationResponse) response_,
                getParentForChildren(),
                isClean());
        response_ = null;
      }
      responseCase_ = 2;
      onChanged();;
      return calculationResponseBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.complex.BaseResponse)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.complex.BaseResponse)
  private static final ru.itmo.java.message.complex.BaseResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.complex.BaseResponse();
  }

  public static ru.itmo.java.message.complex.BaseResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BaseResponse>
      PARSER = new com.google.protobuf.AbstractParser<BaseResponse>() {
    @java.lang.Override
    public BaseResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BaseResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BaseResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BaseResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.complex.BaseResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
