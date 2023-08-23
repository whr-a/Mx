  .text
  .globl main
main:
.L0:
  li t0, -16
  add sp, sp, t0
  sw ra, 0(sp)
  li t0, 4
  add t0, sp, t0
  sw t0, 8(sp)
  j .L1
.L1:
  lw t1, 8(sp)
  lw t0, 0(t1)
  sw t0, 12(sp)
  lw t1, 12(sp)
  mv a0, t1
  lw ra, 0(sp)
  li t0, 16
  add sp, sp, t0
  ret
