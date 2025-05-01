from mpi4py import MPI
import numpy as np

comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()

unit_size = 5
total_elements = unit_size * size

# Root initializes the array
if rank == 0:
    data = np.arange(total_elements, dtype='i') # 'i' for integer
    print(f"Input array: {data.tolist()}")
else:
    data = None

# Create a buffer for receiving chunk
recvbuf = np.empty(unit_size, dtype='i')

# Scatter the data
comm.Scatter(data, recvbuf, root=0)

# Calculate local sum
local_sum = np.sum(recvbuf)
print(f"Process {rank} received {recvbuf.tolist()} -> Local sum = {local_sum}")

# Gather all local sums at root
gathered_sums = comm.gather(local_sum, root=0)

# Final sum at root
if rank == 0:
    final_sum = sum(gathered_sums)
    print(f"Intermediate sums: {gathered_sums}")
    print(f"Final sum: {final_sum}")