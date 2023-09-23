  .text
  .globl main
main:
.L0:
  li t0, -8
  add sp, sp, t0
  sw ra, 0(sp)
  li t1, 10
  li t0, 1
  add t0, t1, t0
  sw t0, 4(sp)
  j .L1
.L1:
  li t1, 10
  mv a0, t1
  lw ra, 0(sp)
  li t0, 8
  add sp, sp, t0
  ret
