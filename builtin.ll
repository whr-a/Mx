; ModuleID = 'builtin.c'
source_filename = "builtin.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"

@.str = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.1 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.2 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @print(ptr noundef %str) #0 {
entry:
  %str.addr = alloca ptr, align 4
  store ptr %str, ptr %str.addr, align 4
  %0 = load ptr, ptr %str.addr, align 4
  %call = call i32 (ptr, ...) @printf(ptr noundef @.str, ptr noundef %0)
  ret void
}

declare i32 @printf(ptr noundef, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @println(ptr noundef %str) #0 {
entry:
  %str.addr = alloca ptr, align 4
  store ptr %str, ptr %str.addr, align 4
  %0 = load ptr, ptr %str.addr, align 4
  %call = call i32 (ptr, ...) @printf(ptr noundef @.str.1, ptr noundef %0)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @printInt(i32 noundef %n) #0 {
entry:
  %n.addr = alloca i32, align 4
  store i32 %n, ptr %n.addr, align 4
  %0 = load i32, ptr %n.addr, align 4
  %call = call i32 (ptr, ...) @printf(ptr noundef @.str.2, i32 noundef %0)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @printlnInt(i32 noundef %n) #0 {
entry:
  %n.addr = alloca i32, align 4
  store i32 %n, ptr %n.addr, align 4
  %0 = load i32, ptr %n.addr, align 4
  %call = call i32 (ptr, ...) @printf(ptr noundef @.str.3, i32 noundef %0)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @getString() #0 {
entry:
  %buffer = alloca ptr, align 4
  %call = call ptr @malloc(i32 noundef 4096) #4
  store ptr %call, ptr %buffer, align 4
  %0 = load ptr, ptr %buffer, align 4
  %call1 = call i32 (ptr, ...) @scanf(ptr noundef @.str, ptr noundef %0)
  %1 = load ptr, ptr %buffer, align 4
  ret ptr %1
}

; Function Attrs: allocsize(0)
declare ptr @malloc(i32 noundef) #2

declare i32 @scanf(ptr noundef, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @getInt() #0 {
entry:
  %n = alloca i32, align 4
  %call = call i32 (ptr, ...) @scanf(ptr noundef @.str.2, ptr noundef %n)
  %0 = load i32, ptr %n, align 4
  ret i32 %0
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @toString(i32 noundef %n) #0 {
entry:
  %n.addr = alloca i32, align 4
  %buffer = alloca ptr, align 4
  store i32 %n, ptr %n.addr, align 4
  %call = call ptr @malloc(i32 noundef 16) #4
  store ptr %call, ptr %buffer, align 4
  %0 = load ptr, ptr %buffer, align 4
  %1 = load i32, ptr %n.addr, align 4
  %call1 = call i32 (ptr, ptr, ...) @sprintf(ptr noundef %0, ptr noundef @.str.2, i32 noundef %1)
  %2 = load ptr, ptr %buffer, align 4
  ret ptr %2
}

declare i32 @sprintf(ptr noundef, ptr noundef, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @string_string() #0 {
entry:
  %buffer = alloca ptr, align 4
  %call = call ptr @malloc(i32 noundef 1) #4
  store ptr %call, ptr %buffer, align 4
  %0 = load ptr, ptr %buffer, align 4
  %arrayidx = getelementptr inbounds i8, ptr %0, i32 0
  store i8 0, ptr %arrayidx, align 1
  %1 = load ptr, ptr %buffer, align 4
  ret ptr %1
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_length(ptr noundef %__this) #0 {
entry:
  %__this.addr = alloca ptr, align 4
  store ptr %__this, ptr %__this.addr, align 4
  %0 = load ptr, ptr %__this.addr, align 4
  %call = call i32 @strlen(ptr noundef %0)
  ret i32 %call
}

declare i32 @strlen(ptr noundef) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @string_substring(ptr noundef %__this, i32 noundef %left, i32 noundef %right) #0 {
entry:
  %__this.addr = alloca ptr, align 4
  %left.addr = alloca i32, align 4
  %right.addr = alloca i32, align 4
  %length = alloca i32, align 4
  %buffer = alloca ptr, align 4
  store ptr %__this, ptr %__this.addr, align 4
  store i32 %left, ptr %left.addr, align 4
  store i32 %right, ptr %right.addr, align 4
  %0 = load i32, ptr %right.addr, align 4
  %1 = load i32, ptr %left.addr, align 4
  %sub = sub nsw i32 %0, %1
  store i32 %sub, ptr %length, align 4
  %2 = load i32, ptr %length, align 4
  %add = add nsw i32 %2, 1
  %call = call ptr @malloc(i32 noundef %add) #4
  store ptr %call, ptr %buffer, align 4
  %3 = load ptr, ptr %buffer, align 4
  %4 = load ptr, ptr %__this.addr, align 4
  %5 = load i32, ptr %left.addr, align 4
  %add.ptr = getelementptr inbounds i8, ptr %4, i32 %5
  %6 = load i32, ptr %length, align 4
  call void @llvm.memcpy.p0.p0.i32(ptr align 1 %3, ptr align 1 %add.ptr, i32 %6, i1 false)
  %7 = load ptr, ptr %buffer, align 4
  %8 = load i32, ptr %length, align 4
  %arrayidx = getelementptr inbounds i8, ptr %7, i32 %8
  store i8 0, ptr %arrayidx, align 1
  %9 = load ptr, ptr %buffer, align 4
  ret ptr %9
}

; Function Attrs: argmemonly nocallback nofree nounwind willreturn
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_parseInt(ptr noundef %__this) #0 {
entry:
  %__this.addr = alloca ptr, align 4
  %n = alloca i32, align 4
  store ptr %__this, ptr %__this.addr, align 4
  %0 = load ptr, ptr %__this.addr, align 4
  %call = call i32 (ptr, ptr, ...) @sscanf(ptr noundef %0, ptr noundef @.str.2, ptr noundef %n)
  %1 = load i32, ptr %n, align 4
  ret i32 %1
}

declare i32 @sscanf(ptr noundef, ptr noundef, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_ord(ptr noundef %__this, i32 noundef %pos) #0 {
entry:
  %__this.addr = alloca ptr, align 4
  %pos.addr = alloca i32, align 4
  store ptr %__this, ptr %__this.addr, align 4
  store i32 %pos, ptr %pos.addr, align 4
  %0 = load ptr, ptr %__this.addr, align 4
  %1 = load i32, ptr %pos.addr, align 4
  %arrayidx = getelementptr inbounds i8, ptr %0, i32 %1
  %2 = load i8, ptr %arrayidx, align 1
  %conv = sext i8 %2 to i32
  ret i32 %conv
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @string_add(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  %length1 = alloca i32, align 4
  %length2 = alloca i32, align 4
  %length = alloca i32, align 4
  %buffer = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %call = call i32 @strlen(ptr noundef %0)
  store i32 %call, ptr %length1, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call1 = call i32 @strlen(ptr noundef %1)
  store i32 %call1, ptr %length2, align 4
  %2 = load i32, ptr %length1, align 4
  %3 = load i32, ptr %length2, align 4
  %add = add nsw i32 %2, %3
  store i32 %add, ptr %length, align 4
  %4 = load i32, ptr %length, align 4
  %add2 = add nsw i32 %4, 1
  %call3 = call ptr @malloc(i32 noundef %add2) #4
  store ptr %call3, ptr %buffer, align 4
  %5 = load ptr, ptr %buffer, align 4
  %6 = load ptr, ptr %str1.addr, align 4
  %7 = load i32, ptr %length1, align 4
  call void @llvm.memcpy.p0.p0.i32(ptr align 1 %5, ptr align 1 %6, i32 %7, i1 false)
  %8 = load ptr, ptr %buffer, align 4
  %9 = load i32, ptr %length1, align 4
  %add.ptr = getelementptr inbounds i8, ptr %8, i32 %9
  %10 = load ptr, ptr %str2.addr, align 4
  %11 = load i32, ptr %length2, align 4
  call void @llvm.memcpy.p0.p0.i32(ptr align 1 %add.ptr, ptr align 1 %10, i32 %11, i1 false)
  %12 = load ptr, ptr %buffer, align 4
  %13 = load i32, ptr %length, align 4
  %arrayidx = getelementptr inbounds i8, ptr %12, i32 %13
  store i8 0, ptr %arrayidx, align 1
  %14 = load ptr, ptr %buffer, align 4
  ret ptr %14
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_equal(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call = call i32 @strcmp(ptr noundef %0, ptr noundef %1)
  %cmp = icmp eq i32 %call, 0
  ret i1 %cmp
}

declare i32 @strcmp(ptr noundef, ptr noundef) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_notEqual(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call = call i32 @strcmp(ptr noundef %0, ptr noundef %1)
  %cmp = icmp ne i32 %call, 0
  ret i1 %cmp
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_less(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call = call i32 @strcmp(ptr noundef %0, ptr noundef %1)
  %cmp = icmp slt i32 %call, 0
  ret i1 %cmp
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_lessOrEqual(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call = call i32 @strcmp(ptr noundef %0, ptr noundef %1)
  %cmp = icmp sle i32 %call, 0
  ret i1 %cmp
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_greater(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call = call i32 @strcmp(ptr noundef %0, ptr noundef %1)
  %cmp = icmp sgt i32 %call, 0
  ret i1 %cmp
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_greaterOrEqual(ptr noundef %str1, ptr noundef %str2) #0 {
entry:
  %str1.addr = alloca ptr, align 4
  %str2.addr = alloca ptr, align 4
  store ptr %str1, ptr %str1.addr, align 4
  store ptr %str2, ptr %str2.addr, align 4
  %0 = load ptr, ptr %str1.addr, align 4
  %1 = load ptr, ptr %str2.addr, align 4
  %call = call i32 @strcmp(ptr noundef %0, ptr noundef %1)
  %cmp = icmp sge i32 %call, 0
  ret i1 %cmp
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @__array_size(ptr noundef %__this) #0 {
entry:
  %__this.addr = alloca ptr, align 4
  store ptr %__this, ptr %__this.addr, align 4
  %0 = load ptr, ptr %__this.addr, align 4
  %arrayidx = getelementptr inbounds i32, ptr %0, i32 -1
  %1 = load i32, ptr %arrayidx, align 4
  ret i32 %1
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @__newPtrArray(i32 noundef %size, i32 noundef %elemSize) #0 {
entry:
  %size.addr = alloca i32, align 4
  %elemSize.addr = alloca i32, align 4
  %array = alloca ptr, align 4
  store i32 %size, ptr %size.addr, align 4
  store i32 %elemSize, ptr %elemSize.addr, align 4
  %0 = load i32, ptr %size.addr, align 4
  %call = call ptr @malloc(i32 noundef %0) #4
  store ptr %call, ptr %array, align 4
  %1 = load i32, ptr %elemSize.addr, align 4
  %2 = load ptr, ptr %array, align 4
  %arrayidx = getelementptr inbounds i32, ptr %2, i32 0
  store i32 %1, ptr %arrayidx, align 4
  %3 = load ptr, ptr %array, align 4
  %add.ptr = getelementptr inbounds i32, ptr %3, i32 1
  ret ptr %add.ptr
}

attributes #0 = { noinline nounwind optnone uwtable "frame-pointer"="all" "min-legal-vector-width"="0" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #1 = { "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #2 = { allocsize(0) "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #3 = { argmemonly nocallback nofree nounwind willreturn }
attributes #4 = { allocsize(0) }

!llvm.module.flags = !{!0, !1, !2, !3, !4, !5}
!llvm.ident = !{!6}

!0 = !{i32 1, !"NumRegisterParameters", i32 0}
!1 = !{i32 1, !"wchar_size", i32 4}
!2 = !{i32 7, !"PIC Level", i32 2}
!3 = !{i32 7, !"PIE Level", i32 2}
!4 = !{i32 7, !"uwtable", i32 2}
!5 = !{i32 7, !"frame-pointer", i32 2}
!6 = !{!"Ubuntu clang version 15.0.7"}
