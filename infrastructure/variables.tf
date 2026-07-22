variable "cluster_name" {
  type    = string
  default = "fibonacci-cluster"
}

variable "host_port" {
  type    = number
  default = 8085
}

variable "node_port" {
  type    = number
  default = 31693
}