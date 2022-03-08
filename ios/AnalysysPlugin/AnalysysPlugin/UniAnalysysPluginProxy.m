//
//  UniAnalysysPluginProxy.m
//  AnalysysPlugin
//
//  Created by person on 2021/3/30.
//

#import "UniAnalysysPluginProxy.h"
#import <AnalysysAgent/AnalysysAgent.h>

@implementation UniAnalysysPluginProxy

- (void)onCreateUniPlugin {
    NSLog(@"Uni-AnalysysPlugin initialize sucess");
}

- (BOOL)application:(UIApplication *_Nullable)application didFinishLaunchingWithOptions:(NSDictionary *_Nullable)launchOptions {
    
//    [AnalysysAgent monitorAppDelegate:self launchOptions:launchOptions];
    @try {
        NSString *uni_appkey = [self objectForKey:@"appKey"];
        NSInteger uni_debugMode = [[self objectForKey:@"debugMode"] integerValue];
        NSString *uni_channel = [self objectForKey:@"channel"];
        NSInteger uni_encryptType = [[self objectForKey:@"encryptType"] integerValue];
        NSString *uni_autoPageViewDuration = [self objectForKey:@"autoPageViewDuration"];
        NSString *uni_automaticCollection = [self objectForKey:@"automaticCollection"];
        NSString *uni_automaticHeatmap = [self objectForKey:@"automaticHeatmap"];
        NSString *uni_uploadUrl = [self objectForKey:@"uploadUrl"];
        NSString *uni_debugUrl = [self objectForKey:@"debugUrl"];
        NSString *uni_configUrl = [self objectForKey:@"configUrl"];
        
        if (uni_debugMode == 2) {
            NSLog(@"appkey:%@",uni_appkey);
            NSLog(@"debugMode:%d",(int)uni_debugMode);
            NSLog(@"channel:%@",uni_channel);
            NSLog(@"encryptType:%d",(int)uni_encryptType);
            NSLog(@"autoPageViewDuration:%@",uni_autoPageViewDuration);
            NSLog(@"automaticCollection:%@",uni_automaticCollection);
            NSLog(@"automaticHeatmap:%@",uni_automaticHeatmap);
            NSLog(@"uploadUrl:%@",uni_uploadUrl);
            NSLog(@"debugUrl:%@",uni_debugUrl);
            NSLog(@"configUrl:%@",uni_configUrl);
        }
        
        //  部分设置在SDK初始化前设置
        if (uni_automaticCollection){
            BOOL b_uni_automaticCollection = FALSE;
            if([uni_automaticCollection isEqualToString:@"true"]) {
                b_uni_automaticCollection = TRUE;
            }
            [AnalysysAgent setAutomaticCollection:b_uni_automaticCollection];
        }
        
        
        if (uni_automaticHeatmap){
            BOOL b_uni_automaticHeatmap = FALSE;
            if([uni_automaticHeatmap isEqualToString:@"true"]) {
                b_uni_automaticHeatmap = TRUE;
            }
            [AnalysysAgent setAutomaticHeatmap:b_uni_automaticHeatmap];
        }
        
        
        AnalysysConfig.appKey = uni_appkey;
        AnalysysConfig.channel = uni_channel;
        
        
        
        if (uni_encryptType) {
            if (uni_encryptType == 1) {
                AnalysysConfig.encryptType = AnalysysEncryptAES;
            } else if (uni_encryptType == 2) {
                AnalysysConfig.encryptType = AnalysysEncryptAESCBC128;
            }
            
        }
        
        
        if (uni_autoPageViewDuration) {
            BOOL b_uni_autoPageViewDuration = FALSE;
            if ([uni_autoPageViewDuration isEqualToString:@"true"]) {
                b_uni_autoPageViewDuration = TRUE;
            }
            AnalysysConfig.autoPageViewDuration = b_uni_autoPageViewDuration;
        }
        

        // 使用配置信息初始化SDK
        [AnalysysAgent startWithConfig:AnalysysConfig];
        
        if (uni_debugMode) {
            if (uni_debugMode == 0) {
                [AnalysysAgent setDebugMode:AnalysysDebugOff];
            } else if (uni_debugMode == 1) {
                [AnalysysAgent setDebugMode:AnalysysDebugOnly];
            } else if (uni_debugMode ==2 ){
                [AnalysysAgent setDebugMode:AnalysysDebugButTrack];
            }
        }
        
        
        [AnalysysAgent setUploadURL:uni_uploadUrl];
        

        if (uni_debugMode == 1 || uni_debugMode == 2) {
            [AnalysysAgent setVisitorDebugURL:uni_debugUrl];
        }

        [AnalysysAgent setVisitorConfigURL:uni_configUrl];
    } @catch (NSException *exception) {
        
    }
    
    return YES;
}

- (NSString *)objectForKey:(NSString *)key {
    if (!key.length) {
        return nil;
    }
    NSDictionary *ans = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"AnalysysPlugin"];
    return ans[key];
}

@end
