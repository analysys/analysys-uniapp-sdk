//
//  UniAnalysysAgentModule.m
//  AnalysysPlugin
//
//  Created by person on 2021/3/29.
//

#import "UniAnalysysAgentModule.h"
#import <AnalysysAgent/AnalysysAgent.h>

@implementation UniAnalysysAgentModule
#pragma mark *** 基本配置 ***

/**
 SDK版本信息

 UniApp-Native示例：
 let SDKVersion = UniAnalysysAgentModule.SDKVersion()
 */
UNI_EXPORT_METHOD_SYNC(@selector(SDKVersion))

- (NSString *)SDKVersion {
    NSLog(@"SDKVersion:%@",[AnalysysAgent SDKVersion]);
  return [AnalysysAgent SDKVersion];
}

#pragma mark *** 事件跟踪 ***

/**
 页面跟踪

 UniApp-Native示例：
 UniAnalysysAgentModule.pageView("活动页", {"commodityName":"iPhone","commodityPrice":"5000"})

 @param pageName 页面名称
 @param properties 页面属性
 */
UNI_EXPORT_METHOD_SYNC(@selector(pageView:properties:))
- (void)pageView:(NSString *)pageName properties:(NSDictionary *)properties {
  [AnalysysAgent pageView:pageName properties:properties];
}


/**
 事件跟踪

 UniApp-Native示例：
 UniAnalysysAgentModule.track("buy", {"ptype":"iPhone","model":"Apple iPhone8"})

 @param event 事件名称
 @param properties 事件属性
 */
UNI_EXPORT_METHOD_SYNC(@selector(track:properties:))
- (void)track:(NSString *)event properties:(NSDictionary *)properties {
  [AnalysysAgent track:event properties:properties];
}


#pragma mark *** 通用属性 ***

/**
 注册单个通用属性

 UniApp-Native示例：
 UniAnalysysAgentModule.registerSuperProperty("member","VIP")

 @param superPropertyName 属性名称
 @param superPropertyValue 属性值
 */
UNI_EXPORT_METHOD_SYNC(@selector(registerSuperProperty:value:))
- (void)registerSuperProperty:(NSString *)superPropertyName value:(id)superPropertyValue {
  [AnalysysAgent registerSuperProperty:superPropertyName value:superPropertyValue];
}

/**
 注册多个通用属性

 UniApp-Native示例：
 UniAnalysysAgentModule.registerSuperProperties({"platform":"TX","age":"20"})

 @param superProperties 属性信息
 */
UNI_EXPORT_METHOD_SYNC(@selector(registerSuperProperties:))
- (void)registerSuperProperties:(NSDictionary *)superProperties {
  [AnalysysAgent registerSuperProperties:superProperties];
}

/**
 删除单个通用属性

 UniApp-Native示例：
 UniAnalysysAgentModule.unRegisterSuperProperty("age")

 @param superPropertyName 属性key
 */
UNI_EXPORT_METHOD_SYNC(@selector(unRegisterSuperProperty:))

- (void)unRegisterSuperProperty:(NSString *)superPropertyName {
  [AnalysysAgent unRegisterSuperProperty:superPropertyName];
}

/**
 清除所有通用属性

 UniApp-Native示例：
 UniAnalysysAgentModule.clearSuperProperties()
 */
UNI_EXPORT_METHOD_SYNC(@selector(clearSuperProperties))
- (void)clearSuperProperties {
  [AnalysysAgent clearSuperProperties];
}

/**
 获取某个通用属性

 UniApp-Native示例：
 let superProperty = UniAnalysysAgentModule.getSuperProperty("member")

 @param superPropertyName 属性key
 */
UNI_EXPORT_METHOD_SYNC(@selector(getSuperProperty:))
- (id)getSuperProperty:(NSString *)superPropertyName {
  return [AnalysysAgent getSuperProperty:superPropertyName];
}

/**
 获取已注册通用属性

 UniApp-Native示例：
 let superProperties = UniAnalysysAgentModule.getSuperProperties()
 */
UNI_EXPORT_METHOD_SYNC(@selector(getSuperProperties))
- (NSDictionary *)getSuperProperties {
  return [AnalysysAgent getSuperProperties];
}


#pragma mark *** 用户属性 ***

/**
 用户ID设置，长度大于0且小于255字符

 UniApp-Native示例：
 UniAnalysysAgentModule.identify("zhangsan")

 @param distinctId 用户ID
 */
UNI_EXPORT_METHOD_SYNC(@selector(identify:))
- (void)identify:(NSString *)distinctId {
  [AnalysysAgent identify:distinctId];
}

/**
 用户关联，长度大于0且小于255字符

 UniApp-Native示例：
 UniAnalysysAgentModule.alias("newUserId","oldUserId");

 @param aliasId 将要使用的用户标识
 @param originalId 原有用户标识
 */
UNI_EXPORT_METHOD_SYNC(@selector(alias:originalId:))
- (void)alias:(NSString *)aliasId originalId:(NSString *)originalId __attribute__((deprecated("已过时！建议使用alias:接口"))) {
  [AnalysysAgent alias:aliasId originalId:originalId];
}

/**
 设置用户属性

 UniApp-Native示例：
 UniAnalysysAgentModule.profileSet({"Email":"yonghu@163.com","WeChatID":"weixinhao"});

 @param property 属性信息
 */
UNI_EXPORT_METHOD_SYNC(@selector(profileSet:))
- (void)profileSet:(NSDictionary *)property {
  [AnalysysAgent profileSet:property];
}

/**
 设置用户固有属性

 UniApp-Native示例：
 UniAnalysysAgentModule.profileSetOnce({"birthday":"1995-10-01"});

 @param property 属性信息
 */
UNI_EXPORT_METHOD_SYNC(@selector(profileSetOnce:))

- (void)profileSetOnce:(NSDictionary *)property {
  [AnalysysAgent profileSetOnce:property];
}

/**
 设置用户属性相对变化值

 UniApp-Native示例：
 UniAnalysysAgentModule.profileIncrement({"gameLevel": 1});

 @param property 属性信息
 */
UNI_EXPORT_METHOD_SYNC(@selector(profileIncrement:))
- (void)profileIncrement:(NSDictionary<NSString*, NSNumber*> *)property {
  [AnalysysAgent profileIncrement:property];
}

/**
 增加列表类型的属性

 UniApp-Native示例：
 UniAnalysysAgentModule.profileAppend({"Hobby":"Football", "Sports":"Run"});

 @param property 属性信息
 */
UNI_EXPORT_METHOD_SYNC(@selector(profileAppend:))

- (void)profileAppend:(NSDictionary *)property {
  [AnalysysAgent profileAppend:property];
}

/**
 删除某个用户属性

 UniApp-Native示例：
 UniAnalysysAgentModule.profileUnset("Hobby");

 @param property 属性名称
 */

UNI_EXPORT_METHOD_SYNC(@selector(profileUnset:))

- (void)profileUnset:(NSString *)propertyName {
  [AnalysysAgent profileUnset:propertyName];
}

/**
 删除当前用户的所有属性

 UniApp-Native示例：
 UniAnalysysAgentModule.profileDelete();
 */

UNI_EXPORT_METHOD_SYNC(@selector(profileDelete))

- (void)profileDelete {
  [AnalysysAgent profileDelete];
}


#pragma mark *** 清除本地设置 ***

/**
 清除本地设置（distinctID、aliasID、superProperties）

 UniApp-Native示例：
 UniAnalysysAgentModule.reset()
 */
UNI_EXPORT_METHOD_SYNC(@selector(reset))

- (void)reset {
  [AnalysysAgent reset];
}


@end





