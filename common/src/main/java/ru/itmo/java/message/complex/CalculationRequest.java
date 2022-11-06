// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Complex.proto

package ru.itmo.java.message.complex;

/**
 * Protobuf type {@code ru.itmo.java.message.complex.CalculationRequest}
 */
public final class CalculationRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.complex.CalculationRequest)
    CalculationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CalculationRequest.newBuilder() to construct.
  private CalculationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CalculationRequest() {
    operation_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CalculationRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CalculationRequest(
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
          case 8: {

            x_ = input.readInt32();
            break;
          }
          case 16: {

            y_ = input.readInt32();
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            operation_ = rawValue;
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
    return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_CalculationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_CalculationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.complex.CalculationRequest.class, ru.itmo.java.message.complex.CalculationRequest.Builder.class);
  }

  /**
   * Protobuf enum {@code ru.itmo.java.message.complex.CalculationRequest.Operation}
   */
  public enum Operation
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>Add = 0;</code>
     */
    Add(0),
    /**
     * <code>Sub = 1;</code>
     */
    Sub(1),
    /**
     * <code>Mul = 2;</code>
     */
    Mul(2),
    /**
     * <code>Div = 3;</code>
     */
    Div(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>Add = 0;</code>
     */
    public static final int Add_VALUE = 0;
    /**
     * <code>Sub = 1;</code>
     */
    public static final int Sub_VALUE = 1;
    /**
     * <code>Mul = 2;</code>
     */
    public static final int Mul_VALUE = 2;
    /**
     * <code>Div = 3;</code>
     */
    public static final int Div_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Operation valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Operation forNumber(int value) {
      switch (value) {
        case 0: return Add;
        case 1: return Sub;
        case 2: return Mul;
        case 3: return Div;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Operation>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Operation> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Operation>() {
            public Operation findValueByNumber(int number) {
              return Operation.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return ru.itmo.java.message.complex.CalculationRequest.getDescriptor().getEnumTypes().get(0);
    }

    private static final Operation[] VALUES = values();

    public static Operation valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Operation(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:ru.itmo.java.message.complex.CalculationRequest.Operation)
  }

  public static final int X_FIELD_NUMBER = 1;
  private int x_;
  /**
   * <code>int32 x = 1;</code>
   * @return The x.
   */
  @java.lang.Override
  public int getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 2;
  private int y_;
  /**
   * <code>int32 y = 2;</code>
   * @return The y.
   */
  @java.lang.Override
  public int getY() {
    return y_;
  }

  public static final int OPERATION_FIELD_NUMBER = 3;
  private int operation_;
  /**
   * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
   * @return The enum numeric value on the wire for operation.
   */
  @java.lang.Override public int getOperationValue() {
    return operation_;
  }
  /**
   * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
   * @return The operation.
   */
  @java.lang.Override public ru.itmo.java.message.complex.CalculationRequest.Operation getOperation() {
    @SuppressWarnings("deprecation")
    ru.itmo.java.message.complex.CalculationRequest.Operation result = ru.itmo.java.message.complex.CalculationRequest.Operation.valueOf(operation_);
    return result == null ? ru.itmo.java.message.complex.CalculationRequest.Operation.UNRECOGNIZED : result;
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
    if (x_ != 0) {
      output.writeInt32(1, x_);
    }
    if (y_ != 0) {
      output.writeInt32(2, y_);
    }
    if (operation_ != ru.itmo.java.message.complex.CalculationRequest.Operation.Add.getNumber()) {
      output.writeEnum(3, operation_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (x_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, x_);
    }
    if (y_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, y_);
    }
    if (operation_ != ru.itmo.java.message.complex.CalculationRequest.Operation.Add.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, operation_);
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
    if (!(obj instanceof ru.itmo.java.message.complex.CalculationRequest)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.complex.CalculationRequest other = (ru.itmo.java.message.complex.CalculationRequest) obj;

    if (getX()
        != other.getX()) return false;
    if (getY()
        != other.getY()) return false;
    if (operation_ != other.operation_) return false;
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
    hash = (37 * hash) + X_FIELD_NUMBER;
    hash = (53 * hash) + getX();
    hash = (37 * hash) + Y_FIELD_NUMBER;
    hash = (53 * hash) + getY();
    hash = (37 * hash) + OPERATION_FIELD_NUMBER;
    hash = (53 * hash) + operation_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.complex.CalculationRequest parseFrom(
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
  public static Builder newBuilder(ru.itmo.java.message.complex.CalculationRequest prototype) {
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
   * Protobuf type {@code ru.itmo.java.message.complex.CalculationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.complex.CalculationRequest)
      ru.itmo.java.message.complex.CalculationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_CalculationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_CalculationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.complex.CalculationRequest.class, ru.itmo.java.message.complex.CalculationRequest.Builder.class);
    }

    // Construct using ru.itmo.java.message.complex.CalculationRequest.newBuilder()
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
      x_ = 0;

      y_ = 0;

      operation_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.complex.Complex.internal_static_ru_itmo_java_message_complex_CalculationRequest_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.complex.CalculationRequest getDefaultInstanceForType() {
      return ru.itmo.java.message.complex.CalculationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.complex.CalculationRequest build() {
      ru.itmo.java.message.complex.CalculationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.complex.CalculationRequest buildPartial() {
      ru.itmo.java.message.complex.CalculationRequest result = new ru.itmo.java.message.complex.CalculationRequest(this);
      result.x_ = x_;
      result.y_ = y_;
      result.operation_ = operation_;
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
      if (other instanceof ru.itmo.java.message.complex.CalculationRequest) {
        return mergeFrom((ru.itmo.java.message.complex.CalculationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.complex.CalculationRequest other) {
      if (other == ru.itmo.java.message.complex.CalculationRequest.getDefaultInstance()) return this;
      if (other.getX() != 0) {
        setX(other.getX());
      }
      if (other.getY() != 0) {
        setY(other.getY());
      }
      if (other.operation_ != 0) {
        setOperationValue(other.getOperationValue());
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
      ru.itmo.java.message.complex.CalculationRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.complex.CalculationRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int x_ ;
    /**
     * <code>int32 x = 1;</code>
     * @return The x.
     */
    @java.lang.Override
    public int getX() {
      return x_;
    }
    /**
     * <code>int32 x = 1;</code>
     * @param value The x to set.
     * @return This builder for chaining.
     */
    public Builder setX(int value) {
      
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 x = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearX() {
      
      x_ = 0;
      onChanged();
      return this;
    }

    private int y_ ;
    /**
     * <code>int32 y = 2;</code>
     * @return The y.
     */
    @java.lang.Override
    public int getY() {
      return y_;
    }
    /**
     * <code>int32 y = 2;</code>
     * @param value The y to set.
     * @return This builder for chaining.
     */
    public Builder setY(int value) {
      
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 y = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearY() {
      
      y_ = 0;
      onChanged();
      return this;
    }

    private int operation_ = 0;
    /**
     * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
     * @return The enum numeric value on the wire for operation.
     */
    @java.lang.Override public int getOperationValue() {
      return operation_;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
     * @param value The enum numeric value on the wire for operation to set.
     * @return This builder for chaining.
     */
    public Builder setOperationValue(int value) {
      
      operation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
     * @return The operation.
     */
    @java.lang.Override
    public ru.itmo.java.message.complex.CalculationRequest.Operation getOperation() {
      @SuppressWarnings("deprecation")
      ru.itmo.java.message.complex.CalculationRequest.Operation result = ru.itmo.java.message.complex.CalculationRequest.Operation.valueOf(operation_);
      return result == null ? ru.itmo.java.message.complex.CalculationRequest.Operation.UNRECOGNIZED : result;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
     * @param value The operation to set.
     * @return This builder for chaining.
     */
    public Builder setOperation(ru.itmo.java.message.complex.CalculationRequest.Operation value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      operation_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.complex.CalculationRequest.Operation operation = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOperation() {
      
      operation_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.complex.CalculationRequest)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.complex.CalculationRequest)
  private static final ru.itmo.java.message.complex.CalculationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.complex.CalculationRequest();
  }

  public static ru.itmo.java.message.complex.CalculationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CalculationRequest>
      PARSER = new com.google.protobuf.AbstractParser<CalculationRequest>() {
    @java.lang.Override
    public CalculationRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CalculationRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CalculationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CalculationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.complex.CalculationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

