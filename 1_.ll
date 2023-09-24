
declare dso_local ptr @malloc(i32)
declare dso_local i32 @strlen(ptr)
declare dso_local void @print(ptr)
declare dso_local void @println(ptr)
declare dso_local void @printInt(i32)
declare dso_local void @printlnInt(i32)
declare i32 @string_length(ptr)
declare dso_local ptr @getString()
declare dso_local i32 @getInt()
declare dso_local ptr @toString(i32)
declare ptr @string_substring(ptr, i32, i32)
declare i32 @string_parseInt(ptr)
declare i32 @string_ord(ptr, i32)
declare ptr @string_add(ptr, ptr)
declare i1 @string_equal(ptr, ptr)
declare i1 @string_notEqual(ptr, ptr)
declare i1 @string_less(ptr, ptr)
declare i1 @string_lessOrEqual(ptr, ptr)
declare i1 @string_greater(ptr, ptr)
declare i1 @string_greaterOrEqual(ptr, ptr)

declare i32 @__array_size(ptr)
declare ptr @__newPtrArray(i32, i32)
define i32 @main() {
entry_0:
  %retval = alloca i32
  %.2 = alloca i32
  %.3 = alloca ptr
  %.8 = alloca i32
  store i32 10, ptr %.2
  %.4 = load i32, ptr %.2
  %.5 = mul i32 %.4, 4
  %.6 = add i32 %.5, 4
  %.7 = call ptr @__newPtrArray(i32 %.6, i32 %.4)
  store i32 0, ptr %.8
  br label %for.cond_2
for.cond_2:
  %.10 = load i32, ptr %.8
  %.9 = icmp slt i32 %.10, %.4
  br i1 %.9, label %for.loop_3, label %for.end_5
for.loop_3:
  %.11 = load i32, ptr %.2
  %.12 = mul i32 %.11, 4
  %.13 = add i32 %.12, 4
  %.14 = call ptr @__newPtrArray(i32 %.13, i32 %.11)
  %.16 = load i32, ptr %.8
  %.15 = getelementptr ptr, ptr %.7, i32 %.16
  store ptr %.14, ptr %.15
  br label %for.step_4
for.step_4:
  %.18 = load i32, ptr %.8
  %.17 = add i32 %.18, 1
  store i32 %.17, ptr %.8
  br label %for.cond_2
for.end_5:
  store ptr %.7, ptr %.3
  br label %return_1
return_1:
  %.1 = load i32, ptr %retval
  ret i32 %.1
}

