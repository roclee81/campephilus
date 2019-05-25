// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protobuf_after_operation_info.proto

package org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo;

public final class ProtobufAfterOperationInfo {
  private ProtobufAfterOperationInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AfterOperationInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     **
     * 标记id，自动增长
     * </pre>
     *
     * <code>int32 afterOperationId = 1;</code>
     */
    int getAfterOperationId();

    /**
     * <pre>
     **
     * 反馈信息
     * </pre>
     *
     * <code>string feedbackContent = 2;</code>
     */
    java.lang.String getFeedbackContent();
    /**
     * <pre>
     **
     * 反馈信息
     * </pre>
     *
     * <code>string feedbackContent = 2;</code>
     */
    com.google.protobuf.ByteString
        getFeedbackContentBytes();

    /**
     * <pre>
     **
     * 住院号
     * </pre>
     *
     * <code>string admissionNumber = 3;</code>
     */
    java.lang.String getAdmissionNumber();
    /**
     * <pre>
     **
     * 住院号
     * </pre>
     *
     * <code>string admissionNumber = 3;</code>
     */
    com.google.protobuf.ByteString
        getAdmissionNumberBytes();
  }
  /**
   * Protobuf type {@code org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo}
   */
  public  static final class AfterOperationInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo)
      AfterOperationInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AfterOperationInfo.newBuilder() to construct.
    private AfterOperationInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AfterOperationInfo() {
      feedbackContent_ = "";
      admissionNumber_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AfterOperationInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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

              afterOperationId_ = input.readInt32();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              feedbackContent_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              admissionNumber_ = s;
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
      return org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.class, org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.Builder.class);
    }

    public static final int AFTEROPERATIONID_FIELD_NUMBER = 1;
    private int afterOperationId_;
    /**
     * <pre>
     **
     * 标记id，自动增长
     * </pre>
     *
     * <code>int32 afterOperationId = 1;</code>
     */
    public int getAfterOperationId() {
      return afterOperationId_;
    }

    public static final int FEEDBACKCONTENT_FIELD_NUMBER = 2;
    private volatile java.lang.Object feedbackContent_;
    /**
     * <pre>
     **
     * 反馈信息
     * </pre>
     *
     * <code>string feedbackContent = 2;</code>
     */
    public java.lang.String getFeedbackContent() {
      java.lang.Object ref = feedbackContent_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        feedbackContent_ = s;
        return s;
      }
    }
    /**
     * <pre>
     **
     * 反馈信息
     * </pre>
     *
     * <code>string feedbackContent = 2;</code>
     */
    public com.google.protobuf.ByteString
        getFeedbackContentBytes() {
      java.lang.Object ref = feedbackContent_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        feedbackContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ADMISSIONNUMBER_FIELD_NUMBER = 3;
    private volatile java.lang.Object admissionNumber_;
    /**
     * <pre>
     **
     * 住院号
     * </pre>
     *
     * <code>string admissionNumber = 3;</code>
     */
    public java.lang.String getAdmissionNumber() {
      java.lang.Object ref = admissionNumber_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        admissionNumber_ = s;
        return s;
      }
    }
    /**
     * <pre>
     **
     * 住院号
     * </pre>
     *
     * <code>string admissionNumber = 3;</code>
     */
    public com.google.protobuf.ByteString
        getAdmissionNumberBytes() {
      java.lang.Object ref = admissionNumber_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        admissionNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (afterOperationId_ != 0) {
        output.writeInt32(1, afterOperationId_);
      }
      if (!getFeedbackContentBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, feedbackContent_);
      }
      if (!getAdmissionNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, admissionNumber_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (afterOperationId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, afterOperationId_);
      }
      if (!getFeedbackContentBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, feedbackContent_);
      }
      if (!getAdmissionNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, admissionNumber_);
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
      if (!(obj instanceof org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo)) {
        return super.equals(obj);
      }
      org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo other = (org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo) obj;

      if (getAfterOperationId()
          != other.getAfterOperationId()) return false;
      if (!getFeedbackContent()
          .equals(other.getFeedbackContent())) return false;
      if (!getAdmissionNumber()
          .equals(other.getAdmissionNumber())) return false;
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
      hash = (37 * hash) + AFTEROPERATIONID_FIELD_NUMBER;
      hash = (53 * hash) + getAfterOperationId();
      hash = (37 * hash) + FEEDBACKCONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getFeedbackContent().hashCode();
      hash = (37 * hash) + ADMISSIONNUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getAdmissionNumber().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parseFrom(
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
    public static Builder newBuilder(org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo prototype) {
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
     * Protobuf type {@code org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo)
        org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.class, org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.Builder.class);
      }

      // Construct using org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.newBuilder()
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
        afterOperationId_ = 0;

        feedbackContent_ = "";

        admissionNumber_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_descriptor;
      }

      @java.lang.Override
      public org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo getDefaultInstanceForType() {
        return org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.getDefaultInstance();
      }

      @java.lang.Override
      public org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo build() {
        org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo buildPartial() {
        org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo result = new org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo(this);
        result.afterOperationId_ = afterOperationId_;
        result.feedbackContent_ = feedbackContent_;
        result.admissionNumber_ = admissionNumber_;
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
        if (other instanceof org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo) {
          return mergeFrom((org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo other) {
        if (other == org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo.getDefaultInstance()) return this;
        if (other.getAfterOperationId() != 0) {
          setAfterOperationId(other.getAfterOperationId());
        }
        if (!other.getFeedbackContent().isEmpty()) {
          feedbackContent_ = other.feedbackContent_;
          onChanged();
        }
        if (!other.getAdmissionNumber().isEmpty()) {
          admissionNumber_ = other.admissionNumber_;
          onChanged();
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
        org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int afterOperationId_ ;
      /**
       * <pre>
       **
       * 标记id，自动增长
       * </pre>
       *
       * <code>int32 afterOperationId = 1;</code>
       */
      public int getAfterOperationId() {
        return afterOperationId_;
      }
      /**
       * <pre>
       **
       * 标记id，自动增长
       * </pre>
       *
       * <code>int32 afterOperationId = 1;</code>
       */
      public Builder setAfterOperationId(int value) {
        
        afterOperationId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       * 标记id，自动增长
       * </pre>
       *
       * <code>int32 afterOperationId = 1;</code>
       */
      public Builder clearAfterOperationId() {
        
        afterOperationId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object feedbackContent_ = "";
      /**
       * <pre>
       **
       * 反馈信息
       * </pre>
       *
       * <code>string feedbackContent = 2;</code>
       */
      public java.lang.String getFeedbackContent() {
        java.lang.Object ref = feedbackContent_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          feedbackContent_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       **
       * 反馈信息
       * </pre>
       *
       * <code>string feedbackContent = 2;</code>
       */
      public com.google.protobuf.ByteString
          getFeedbackContentBytes() {
        java.lang.Object ref = feedbackContent_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          feedbackContent_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       **
       * 反馈信息
       * </pre>
       *
       * <code>string feedbackContent = 2;</code>
       */
      public Builder setFeedbackContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        feedbackContent_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       * 反馈信息
       * </pre>
       *
       * <code>string feedbackContent = 2;</code>
       */
      public Builder clearFeedbackContent() {
        
        feedbackContent_ = getDefaultInstance().getFeedbackContent();
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       * 反馈信息
       * </pre>
       *
       * <code>string feedbackContent = 2;</code>
       */
      public Builder setFeedbackContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        feedbackContent_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object admissionNumber_ = "";
      /**
       * <pre>
       **
       * 住院号
       * </pre>
       *
       * <code>string admissionNumber = 3;</code>
       */
      public java.lang.String getAdmissionNumber() {
        java.lang.Object ref = admissionNumber_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          admissionNumber_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       **
       * 住院号
       * </pre>
       *
       * <code>string admissionNumber = 3;</code>
       */
      public com.google.protobuf.ByteString
          getAdmissionNumberBytes() {
        java.lang.Object ref = admissionNumber_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          admissionNumber_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       **
       * 住院号
       * </pre>
       *
       * <code>string admissionNumber = 3;</code>
       */
      public Builder setAdmissionNumber(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        admissionNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       * 住院号
       * </pre>
       *
       * <code>string admissionNumber = 3;</code>
       */
      public Builder clearAdmissionNumber() {
        
        admissionNumber_ = getDefaultInstance().getAdmissionNumber();
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       * 住院号
       * </pre>
       *
       * <code>string admissionNumber = 3;</code>
       */
      public Builder setAdmissionNumberBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        admissionNumber_ = value;
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


      // @@protoc_insertion_point(builder_scope:org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo)
    }

    // @@protoc_insertion_point(class_scope:org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.AfterOperationInfo)
    private static final org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo();
    }

    public static org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AfterOperationInfo>
        PARSER = new com.google.protobuf.AbstractParser<AfterOperationInfo>() {
      @java.lang.Override
      public AfterOperationInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AfterOperationInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AfterOperationInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AfterOperationInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.ProtobufAfterOperationInfo.AfterOperationInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#protobuf_after_operation_info.proto\022Eo" +
      "rg.cqu.edu.msc.annihilation.campephilus." +
      "module.message.protobuf.pojo\"`\n\022AfterOpe" +
      "rationInfo\022\030\n\020afterOperationId\030\001 \001(\005\022\027\n\017" +
      "feedbackContent\030\002 \001(\t\022\027\n\017admissionNumber" +
      "\030\003 \001(\tb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_cqu_edu_msc_annihilation_campephilus_module_message_protobuf_pojo_AfterOperationInfo_descriptor,
        new java.lang.String[] { "AfterOperationId", "FeedbackContent", "AdmissionNumber", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
